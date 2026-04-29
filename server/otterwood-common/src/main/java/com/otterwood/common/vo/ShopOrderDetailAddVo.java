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
public class ShopOrderDetailAddVo {

    /** 商品详情数组 */
    @TableField(value = "product_infos")
    private List<ShopOrderProductInfoAddVo> productInfos;

    /** 支付详情数组 */
    @TableField(value = "pay_info")
    private ShopOrderPayInfoAddVo payInfo;

    /** 价格详情数组 */
    @TableField(value = "price_info")
    private ShopOrderPriceInfoVo priceInfo;
}
