package com.otterwood.service.service;

import jakarta.servlet.http.HttpServletRequest;

/**
 * 订单支付回调 service
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
public interface CallbackService {
    /**
     * 微信支付回调
     * @param xmlInfo 微信回调json
     * @return String
     */
    String weChat(String xmlInfo);

    /**
     * 微信退款回调
     * @param request 微信回调json
     * @return String
     */
    String weChatRefund(String request);
}
