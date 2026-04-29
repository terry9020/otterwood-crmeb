package com.otterwood.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 用户资金统计
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserBalanceResponse对象", description="用户资金统计")
public class UserBalanceResponse implements Serializable {
    public UserBalanceResponse(){}
    public UserBalanceResponse(BigDecimal nowMoney, BigDecimal recharge, BigDecimal orderStatusSum) {
        this.nowMoney = nowMoney;
        this.recharge = recharge;
        this.orderStatusSum = orderStatusSum;
    }

    private static final long serialVersionUID=1L;


    @ApiModelProperty(value = "当前总资金")
    private BigDecimal nowMoney;

    @ApiModelProperty(value = "累计充值")
    private BigDecimal recharge;

    @ApiModelProperty(value = "累计消费")
    private BigDecimal orderStatusSum;

}
