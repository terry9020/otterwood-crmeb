package com.otterwood.common.response;

import com.otterwood.common.model.user.User;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 会员详情顶部信息
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
public class TopDetail {

    private User user;
    // 余额
    private BigDecimal balance;
    // 积分
    private Integer integralCount;
    // 总计订单
    private Integer allOrderCount;
    // 本月订单
    private Integer mothOrderCount;
    // 总消费金额
    private BigDecimal allConsumeCount;
    // 本月消费金额
    private BigDecimal mothConsumeCount;
}
