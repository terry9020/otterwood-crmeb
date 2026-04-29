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
public class ShopOrderPriceInfoVo {

    /** 该订单最终的金额（单位：分） */
    @TableField(value = "order_price")
    private Long orderPrice;

    /** 运费（单位：分） */
    private Long freight;

    /** 优惠金额（单位：分） */
    @TableField(value = "discounted_price")
    private Long discountedPrice;

    /** 附加金额（单位：分） */
    @TableField(value = "additional_price")
    private Long additionalPrice;

    /** 附加金额备注 */
    @TableField(value = "additional_remarks")
    private String additional_remarks;
}
