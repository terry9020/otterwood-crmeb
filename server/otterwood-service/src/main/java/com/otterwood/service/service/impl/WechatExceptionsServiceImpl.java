package com.otterwood.service.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.otterwood.common.model.wechat.WechatExceptions;
import com.otterwood.service.dao.WechatExceptionsDao;
import com.otterwood.service.service.WechatExceptionsService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.Date;

/**
 *  微信异常服务实现类
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
public class WechatExceptionsServiceImpl extends ServiceImpl<WechatExceptionsDao, WechatExceptions> implements WechatExceptionsService {

    @Resource
    private WechatExceptionsDao dao;


    /**
     * 自动删除日志
     * 只保留十天的日志
     */
    @Override
    public void autoDeleteLog() {
        String beforeDate = DateUtil.offsetDay(new Date(), -9).toString("yyyy-MM-dd");
        UpdateWrapper<WechatExceptions> wrapper = Wrappers.update();
        wrapper.lt("create_time", beforeDate);
        dao.delete(wrapper);
    }
}

