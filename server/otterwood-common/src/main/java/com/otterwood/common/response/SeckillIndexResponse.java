package com.otterwood.common.response;

import com.otterwood.common.model.seckill.StoreSeckill;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 秒杀首页响应对象
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SeckillIndexResponse对象", description="秒杀首页响应对象")
public class SeckillIndexResponse {

    @ApiModelProperty(value = "秒杀时段信息")
    private SecKillResponse secKillResponse;

    @ApiModelProperty(value = "秒杀商品信息")
    private List<StoreSeckill> productList;
}
