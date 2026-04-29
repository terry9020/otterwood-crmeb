package com.otterwood.service.dao;

import com.otterwood.common.request.StoreNearRequest;
import com.otterwood.common.vo.SystemStoreNearVo;
import com.otterwood.common.model.system.SystemStore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 门店自提 Mapper 接口
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
public interface SystemStoreDao extends BaseMapper<SystemStore> {

    List<SystemStoreNearVo> getNearList(StoreNearRequest request);
}

