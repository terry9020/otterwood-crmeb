package com.otterwood.common.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * 生成订单Vo对象
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
public class ShopOrderAddResultVo {

    /** 交易组件平台订单ID */
    @TableField(value = "order_id")
    private Long orderId;

    /** 交易组件平台订单ID */
    @TableField(value = "out_order_id")
    private String outOrderId;

    /** 拉起收银台的ticket */
    private String ticket;

    /** ticket有效截止时间 */
    @TableField(value = "ticket_expire_time")
    private String ticketExpireTime;

    /** 订单最终价格（单位：分） */
    @TableField(value = "final_price")
    private Long finalPrice;
}
