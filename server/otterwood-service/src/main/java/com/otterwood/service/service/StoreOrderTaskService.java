package com.otterwood.service.service;


import com.otterwood.common.model.order.StoreOrder;

/**
 * 订单任务服务
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
public interface StoreOrderTaskService {

    Boolean cancelByUser(StoreOrder storeOrder);

    Boolean complete(StoreOrder storeOrder);

    Boolean refundOrder(StoreOrder storeOrder);

    Boolean autoCancel(StoreOrder storeOrder);

    Boolean orderReceiving(Integer orderId);
}
