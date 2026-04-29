package com.otterwood.service.service;

import com.otterwood.common.model.finance.UserRecharge;

/**
 * 订单支付
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
public interface RechargePayService {

    /**
     * 支付成功处理
     * @param userRecharge 充值订单
     */
    Boolean paySuccess(UserRecharge userRecharge);
}
