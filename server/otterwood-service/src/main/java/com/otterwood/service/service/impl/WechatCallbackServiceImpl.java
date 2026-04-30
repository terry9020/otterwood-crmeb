package com.otterwood.service.service.impl;

import cn.hutool.core.date.DateUtil;

import com.alibaba.fastjson.JSONObject;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.otterwood.common.model.wechat.WechatCallback;
import com.otterwood.service.dao.WechatCallbackDao;
import com.otterwood.service.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import jakarta.annotation.Resource;

/**
 * 微信小程序回调Service
 * +----------------------------------------------------------------------
 * | OTTERWOOD [ OTTERWOOD赋能开发者，助力企业发展 ]
 * +----------------------------------------------------------------------
 * | Copyright (c) 2016~2025 https://www.otterwood.com All rights reserved.
 * +----------------------------------------------------------------------
 * | Licensed OTTERWOOD并不是自由软件，未经许可不能去掉OTTERWOOD相关版权
 * +----------------------------------------------------------------------
 * | Author: OTTERWOOD Team <admin@otterwood.com>
 * +----------------------------------------------------------------------
 */
@Service
public class WechatCallbackServiceImpl extends ServiceImpl<WechatCallbackDao, WechatCallback> implements WechatCallbackService {

    private static final Logger logger = LoggerFactory.getLogger(WechatCallbackServiceImpl.class);

    @Resource
    private WechatCallbackDao dao;


    /**
     * 微信回调
     * @param request request
     * @return String
     */
    @Override
    public String callback(String request) {
        System.out.println("微信小程序回调：" + request);
        JSONObject jsonObject = JSONObject.parseObject(request);
        System.out.println("微信小程序回调jsonObject：" + jsonObject);
        WechatCallback wechatCallback = new WechatCallback();
        wechatCallback.setToUserName(jsonObject.getString("ToUserName"));
        wechatCallback.setFromUserName(jsonObject.getString("FromUserName"));
        wechatCallback.setCreateTime(jsonObject.getLong("CreateTime"));
        wechatCallback.setMsgType(jsonObject.getString("MsgType"));
        wechatCallback.setEvent(jsonObject.getString("Event"));
        wechatCallback.setAddTime(DateUtil.date());
        wechatCallback.setContent(request);
        save(wechatCallback);
        switch (wechatCallback.getEvent()) {
        }
        return "success";
    }


}

