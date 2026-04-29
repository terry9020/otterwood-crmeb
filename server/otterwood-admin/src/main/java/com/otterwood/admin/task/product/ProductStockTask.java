package com.otterwood.admin.task.product;

import com.otterwood.common.utils.OtterwoodDateUtil;
import com.otterwood.service.service.StoreBargainService;
import com.otterwood.service.service.StoreCombinationService;
import com.otterwood.service.service.StoreProductService;
import com.otterwood.service.service.StoreSeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** 操作商品库存
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

@Component("ProductStockTask")
public class ProductStockTask {
    //日志
    private static final Logger logger = LoggerFactory.getLogger(ProductStockTask.class);

    @Autowired
    private StoreProductService storeProductService;

    @Autowired
    private StoreSeckillService storeSeckillService;

    @Autowired
    private StoreBargainService storeBargainService;

    @Autowired
    private StoreCombinationService storeCombinationService;

    /**
     * 1分钟同步一次数据
     */
    public void stockOperation() {
        // cron : 0 */1 * * * ?
        logger.info("---OrderTakeByUser task------produce Data with fixed rate task: Execution Time - {}", OtterwoodDateUtil.nowDateTime());
        try {
            storeProductService.consumeProductStock(); // 商品本身库存任务
            storeSeckillService.consumeProductStock(); // 秒杀本身库存任务
            storeBargainService.consumeProductStock(); // 砍价本身库存任务
            storeCombinationService.consumeProductStock(); // 拼团本身库存任务
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("OrderTakeByUser.task" + " | msg : " + e.getMessage());
        }
    }

}
