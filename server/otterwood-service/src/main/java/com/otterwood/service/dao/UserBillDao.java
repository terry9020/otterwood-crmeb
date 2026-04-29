package com.otterwood.service.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.otterwood.common.model.user.UserBill;
import com.otterwood.common.response.UserBillResponse;

import java.util.List;
import java.util.Map;

/**
 * 用户账单表 Mapper 接口
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
public interface UserBillDao extends BaseMapper<UserBill> {

    List<UserBillResponse> fundMonitoring(Map<String, Object> map);
}
