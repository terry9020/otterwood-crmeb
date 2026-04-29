package com.otterwood.common.constants;

/**
 * 定时任务常量类
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
public class TaskConstants {

    /** 订单支付成功后Task */
    public static final String ORDER_TASK_PAY_SUCCESS_AFTER = "orderPaySuccessTask";
    /** 订单收货后Task */
    public static final String ORDER_TASK_REDIS_KEY_AFTER_TAKE_BY_USER = "alterOrderTakeByUser";
}
