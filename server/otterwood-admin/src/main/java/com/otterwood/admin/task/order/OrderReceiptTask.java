package com.otterwood.admin.task.order;

import com.otterwood.common.utils.OtterwoodDateUtil;
import com.otterwood.service.service.OrderTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** 用户确认收货Task
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
@Component("OrderReceiptTask")
public class OrderReceiptTask {
    //日志
    private static final Logger logger = LoggerFactory.getLogger(OrderReceiptTask.class);

    @Autowired
    private OrderTaskService orderTaskService;

    /**
     * 1分钟同步一次数据
     */
    public void orderReceipt() {
        //cron : 0 */1 * * * ?
        logger.info("---OrderReceiptTask task------produce Data with fixed rate task: Execution Time - {}", OtterwoodDateUtil.nowDateTime());
        try {
            orderTaskService.orderReceiving();

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("OrderReceiptTask.task" + " | msg : " + e.getMessage());
        }
    }

}
