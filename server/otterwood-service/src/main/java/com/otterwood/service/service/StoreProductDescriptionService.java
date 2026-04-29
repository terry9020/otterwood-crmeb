package com.otterwood.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.otterwood.common.model.product.StoreProductDescription;

/**
 * StoreProductDescriptionService 接口
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
public interface StoreProductDescriptionService extends IService<StoreProductDescription> {

    /**
     * 根据商品id和type删除对应描述
     * @param productId 商品id
     * @param type      类型
     */
    void deleteByProductId(int productId,int type);

    /**
     * 获取详情
     * @param productId 商品id
     * @param type 商品类型
     * @return
     */
    StoreProductDescription getByProductIdAndType(Integer productId, Integer type);
}
