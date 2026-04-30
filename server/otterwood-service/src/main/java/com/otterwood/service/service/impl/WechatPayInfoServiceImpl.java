package com.otterwood.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.otterwood.common.model.wechat.WechatPayInfo;
import com.otterwood.service.dao.WechatPayInfoDao;
import com.otterwood.service.service.WechatPayInfoService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

/**
 *  WechatPayInfoServiceImpl 接口实现
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
public class WechatPayInfoServiceImpl extends ServiceImpl<WechatPayInfoDao, WechatPayInfo> implements WechatPayInfoService {

    @Resource
    private WechatPayInfoDao dao;

    /**
     * 获取详情（商户订单号）
     * @param outTradeNo 商户订单号
     * @return WechatPayInfo
     */
    @Override
    public WechatPayInfo getByNo(String outTradeNo) {
        LambdaQueryWrapper<WechatPayInfo> lqw = Wrappers.lambdaQuery();
        lqw.eq(WechatPayInfo::getOutTradeNo, outTradeNo);
        return dao.selectOne(lqw);
    }
}

