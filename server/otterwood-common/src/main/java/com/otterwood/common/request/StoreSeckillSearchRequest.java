package com.otterwood.common.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 秒杀搜索参数
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
public class StoreSeckillSearchRequest {

    @ApiModelProperty(value = "搜索关键字 商品id或者名称")
    private String keywords;

    @ApiModelProperty(value = "秒杀时段")
    private Integer timeId;

    @ApiModelProperty(value = "是否显示关键字 0/1")
    private Integer status;
}

