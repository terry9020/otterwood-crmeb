package com.otterwood.admin.task.bargain;

import com.otterwood.common.utils.OtterwoodDateUtil;
import com.otterwood.service.service.StoreBargainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 砍价活动结束状态变化定时任务
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
@Component("BargainStopChangeTask")
public class BargainStopChangeTask {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(BargainStopChangeTask.class);

    @Autowired
    private StoreBargainService storeBargainService;

    /**
     * 每天0点执行
     */
    public void bargainStopChange() {
        // cron : 0 0 0 */1 * ?
        logger.info("---BargainStopChangeTask------bargain stop status change task: Execution Time - {}", OtterwoodDateUtil.nowDateTime());
        try {
            storeBargainService.stopAfterChange();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("BargainStopChangeTask" + " | msg : " + e.getMessage());
        }
    }

}
