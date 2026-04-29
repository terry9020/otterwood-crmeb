package com.otterwood.common.vo;

import lombok.Data;

import java.util.List;

/**
 *  自定义交易组件商品详情Vo
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
public class ShopSpuInfoVo {

    /** 商品详情图文 */
    private String desc;

    /** 商品详情图片 */
    private List<String> imgs;

}
