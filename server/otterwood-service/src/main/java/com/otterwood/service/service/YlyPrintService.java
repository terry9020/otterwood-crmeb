package com.otterwood.service.service;

/**
 * 易联云打印订单 service
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
public interface YlyPrintService {
    /**
     * 易联云打印商品信息
     * @param ordId 订单id
     * @param isAuto 是否自动打印
     */
    void YlyPrint(String ordId,boolean isAuto);
}
