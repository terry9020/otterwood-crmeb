package com.otterwood.service.service;

import com.otterwood.common.response.HomeOperatingDataResponse;
import com.otterwood.common.response.HomeRateResponse;

import java.util.Map;

/**
 * 首页统计
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
public interface HomeService{

    /**
     * 用户曲线图
     */
    Map<Object, Object> chartUser();

    /**
     * 30天订单量趋势
     */
    Map<String, Object> chartOrder();

    /**
     * 用户购买统计
     */
    Map<String, Integer> chartUserBuy();

    /**
     * 周订单量趋势
     */
    Map<String, Object> chartOrderInWeek();

    /**
     * 月订单量趋势
     */
    Map<String, Object> chartOrderInMonth();

    /**
     * 年订单量趋势
     */
    Map<String, Object> chartOrderInYear();

    /**
     * 首页数据
     * @return HomeRateResponse
     */
    HomeRateResponse indexDate();

    /**
     * 经营数据
     * @return HomeOperatingDataResponse
     */
    HomeOperatingDataResponse operatingData();
}
