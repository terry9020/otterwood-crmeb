package com.otterwood.service.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.otterwood.common.request.PageParamRequest;
import com.otterwood.common.request.ExpressUpdateShowRequest;
import com.otterwood.common.exception.OtterwoodException;
import com.github.pagehelper.PageHelper;
import com.otterwood.common.utils.RedisUtil;
import com.otterwood.common.model.express.Express;
import com.otterwood.common.request.ExpressSearchRequest;
import com.otterwood.common.request.ExpressUpdateRequest;
import com.otterwood.service.dao.ExpressDao;
import com.otterwood.service.service.ExpressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import jakarta.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * ExpressServiceImpl 接口实现
 *  +----------------------------------------------------------------------
 *  | OTTERWOOD [ OTTERWOOD赋能开发者，助力企业发展 ]
 *  +----------------------------------------------------------------------
 *  | Copyright (c) 2016~2025 https://www.otterwood.com All rights reserved.
 *  +----------------------------------------------------------------------
 *  | Licensed OTTERWOOD并不是自由软件，未经许可不能去掉OTTERWOOD相关版权
 *  +----------------------------------------------------------------------
 *  | Author: OTTERWOOD Team <admin@otterwood.com>
 *  +----------------------------------------------------------------------
*/
@Service
public class ExpressServiceImpl extends ServiceImpl<ExpressDao, Express> implements ExpressService {

    @Resource
    private ExpressDao dao;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 分页显示快递公司表
     * @param request 搜索条件
     * @param pageParamRequest 分页参数
     */
    @Override
    public List<Express> getList(ExpressSearchRequest request, PageParamRequest pageParamRequest) {
        PageHelper.startPage(pageParamRequest.getPage(), pageParamRequest.getLimit());
        LambdaQueryWrapper<Express> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StrUtil.isNotBlank(request.getKeywords())) {
            lambdaQueryWrapper.like(Express::getCode, request.getKeywords()).or().like(Express::getName, request.getKeywords());
        }
        // 排序：sort字段倒序，正常id正序，方便展示常用物流公司
        lambdaQueryWrapper.orderByDesc(Express::getSort);
        lambdaQueryWrapper.orderByAsc(Express::getId);
        return dao.selectList(lambdaQueryWrapper);
    }

    /**
     * 编辑
     */
    @Override
    public Boolean updateExpress(ExpressUpdateRequest expressRequest) {
        Express temp = getById(expressRequest.getId());
        if (ObjectUtil.isNull(temp)) throw new OtterwoodException("快递公司不存在!");

        if (StrUtil.isBlank(expressRequest.getAccount()) && temp.getPartnerId().equals(true)) {
            throw new OtterwoodException("请输入月结账号");
        }
        if (StrUtil.isBlank(expressRequest.getPassword()) && temp.getPartnerKey().equals(true)) {
            throw new OtterwoodException("请输入月结密码");
        }
        if (StrUtil.isBlank(expressRequest.getNetName()) && temp.getNet().equals(true)) {
            throw new OtterwoodException("请输入取件网点");
        }
        Express express = new Express();
        BeanUtils.copyProperties(expressRequest, express);

        return updateById(express);
    }

    /**
     * 修改显示状态
     */
    @Override
    public Boolean updateExpressShow(ExpressUpdateShowRequest expressRequest) {
        Express temp = getById(expressRequest.getId());
        if (ObjectUtil.isNull(temp)) throw new OtterwoodException("编辑的记录不存在!");
        if (temp.getIsShow().equals(expressRequest.getIsShow())) {
            return Boolean.TRUE;
        }
        Express express = new Express();
        BeanUtils.copyProperties(expressRequest, express);
        return updateById(express);
    }

    /**
     * 同步物流公司（一号通功能，已移除）
     */
    @Override
    public Boolean syncExpress() {
        throw new UnsupportedOperationException("一号通功能已移除");
    }

    /**
     * 查询全部物流公司
     * @param type 类型：normal-普通，elec-电子面单
     */
    @Override
    public List<Express> findAll(String type) {
        LambdaQueryWrapper<Express> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Express::getIsShow, true);
        if (type.equals("elec")) {
            lqw.eq(Express::getStatus, true);
        }
        lqw.orderByDesc(Express::getSort);
        lqw.orderByAsc(Express::getId);
        return dao.selectList(lqw);
    }

    /**
     * 查询物流公司面单模板（一号通功能，已移除）
     */
    @Override
    public JSONObject template(String com) {
        throw new UnsupportedOperationException("一号通功能已移除");
    }

    @Override
    public JSONObject templateFor(String com, String type, String is_shipment, String page, String limit) {
        throw new UnsupportedOperationException("一号通功能已移除");
    }

    /**
     * 查询快递公司
     * @param code 快递公司编号
     */
    @Override
    public Express getByCode(String code) {
        LambdaQueryWrapper<Express> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Express::getCode, code);
        return dao.selectOne(lqw);
    }

    /**
     * 通过物流公司名称获取
     * @param name 物流公司名称
     */
    @Override
    public Express getByName(String name) {
        LambdaQueryWrapper<Express> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Express::getName, name);
        lqw.last(" limit 1");
        return dao.selectOne(lqw);
    }

    /**
     * 获取快递公司详情（一号通功能，已移除）
     */
    @Override
    public Express getInfo(Integer id) {
        Express express = getById(id);
        if (ObjectUtil.isNull(express)) {
            throw new OtterwoodException("快递公司不存在");
        }
        return express;
    }

    /**
     * 获取所有物流公司code
     */
    private List<String> getAllCode() {
        LambdaQueryWrapper<Express> lqw = new LambdaQueryWrapper<>();
        lqw.select(Express::getCode);
        List<Express> expressList = dao.selectList(lqw);
        if (CollUtil.isEmpty(expressList)) {
            return CollUtil.newArrayList();
        }
        return expressList.stream().map(Express::getCode).collect(Collectors.toList());
    }
}

