package com.otterwood.common.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * StoreOrderStatisticsResponse
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
@Data
public class StoreOrderStatisticsResponse {
    @ApiModelProperty(value = "订单数图标数据")
    private List<StoreOrderStatisticsChartItemResponse> chart; // 订单数图标数据

    @ApiModelProperty(value = "时间区间增长率")
    private Integer growthRate; // 时间区间增长率

    @ApiModelProperty(value = "同比")
    private String increaseTime;

    @ApiModelProperty(value = "同比上个时间区间增长营业额 1=增长，2=减少")
    private Integer increaseTimeStatus; // 同比上个时间区间增长营业额 1=增长，2=减少

    @ApiModelProperty(value = "时间区间订单数")
    private BigDecimal time;
}
