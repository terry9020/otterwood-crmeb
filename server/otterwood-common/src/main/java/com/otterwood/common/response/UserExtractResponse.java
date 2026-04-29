package com.otterwood.common.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 提现数据用于分销
 *  +----------------------------------------------------------------------
 *  | OTTERWOOD [ OTTERWOOD赋能开发者，助力企业发展 ]
 *  +----------------------------------------------------------------------
 *  | Copyright (c) 2016~2025 https://www.otterwood.com All rights reserved.
 *  +----------------------------------------------------------------------
 *  | Licensed OTTERWOOD并不是自由软件，未经许可不能去掉OTTERWOOD相关版权
 *  +----------------------------------------------------------------------
 *  | Author: OTTERWOOD Team <admin@otterwood.com>
 *  +----------------------------------------------------------------------
 */
@Data
public class UserExtractResponse {
    // 提现数据总额
    @ApiModelProperty(value = "体现数据总额")
    private BigDecimal extractCountPrice;
    // 提现次数
    @ApiModelProperty(value = "提现次数")
    private Integer extractCountNum;
    // 提现用户id
//    private Integer euid;
}
