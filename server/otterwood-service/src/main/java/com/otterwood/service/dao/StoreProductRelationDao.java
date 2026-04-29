package com.otterwood.service.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.otterwood.common.model.product.StoreProductRelation;
import com.otterwood.common.response.UserRelationResponse;

import java.util.List;

/**
 * 商品点赞和收藏表 Mapper 接口
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
public interface StoreProductRelationDao extends BaseMapper<StoreProductRelation> {

    /**
     * 用户收藏列表
     * @param uid 用户uid
     */
    List<UserRelationResponse> getUserList(Integer uid);
}
