package com.otterwood.service.service;


/**
 * 订单任务服务 StoreOrderService 接口
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
 public interface OrderTaskService{

     void cancelByUser();

     void refundApply();

     void complete();

    void orderPaySuccessAfter();

    /**
     * 自动取消未支付订单
     */
    void autoCancel();

    /**
     * 订单收货
     */
    void orderReceiving();

    /**
     * 订单自动完成
     */
    void autoComplete();

    /**
     * 订单自动收货
     */
    void autoTakeDelivery();
}
