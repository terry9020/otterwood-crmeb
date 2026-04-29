package com.otterwood.common.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

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
public class ShopOrderDetailVo {

    /** 商品详情数组 */
    @TableField(value = "product_infos")
    private List<ShopOrderProductInfoVo> productInfos;

    /** 支付详情数组,payorder时action_type!=6时存在 */
    @TableField(value = "pay_info")
    private ShopOrderPayInfoVo payInfo;

    /** 多用支付详情数组,payorder时action_type=6时存在 */
    @TableField(value = "multi_pay_info")
    private ShopOrderPayInfoVo multiPayInfo;

    /** 价格详情数组 */
    @TableField(value = "price_info")
    private ShopOrderPriceInfoVo priceInfo;

    /** 价格详情数组,必须调过发货接口才会存在这个字段 */
    @TableField(value = "delivery_detail")
    private ShopOrderDeliveryDetailAddVo deliveryDetail;
}
