package com.otterwood.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.List;

/**
 * 拼团商品列表header响应对象
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
@ApiModel(value="CombinationHeaderResponse对象", description="拼团商品列表header响应对象")
public class CombinationHeaderResponse {

    @ApiModelProperty(value = "拼团7位用户头像")
    private List<String> avatarList;

    @ApiModelProperty(value = "拼团总人数")
    private Integer totalPeople;

    @ApiModelProperty(value = "拼团banner数组")
    private List<HashMap<String, Object>> bannerList;
}
