package com.otterwood.admin.task.coupon;

import com.otterwood.common.utils.OtterwoodDateUtil;
import com.otterwood.service.service.StoreCouponUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 优惠券过期定时任务
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
@Component("CouponOverdueTask")
public class CouponOverdueTask {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(CouponOverdueTask.class);

    @Autowired
    private StoreCouponUserService couponUserService;

    /**
     * 1分钟同步一次数据
     */
    public void couponOverdue() {
        // cron : 0 */1 * * * ?
        logger.info("---CouponOverdueTask task------produce Data with fixed rate task: Execution Time - {}", OtterwoodDateUtil.nowDateTime());
        try {
            couponUserService.overdueTask();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("CouponOverdueTask.task" + " | msg : " + e.getMessage());
        }
    }

}
