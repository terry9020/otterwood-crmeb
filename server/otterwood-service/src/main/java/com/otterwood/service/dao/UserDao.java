package com.otterwood.service.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.otterwood.common.model.user.User;
import com.otterwood.common.response.UserSpreadPeopleItemResponse;

import java.util.List;
import java.util.Map;

/**
 * 用户表 Mapper 接口
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
public interface UserDao extends BaseMapper<User> {

    List<UserSpreadPeopleItemResponse> getSpreadPeopleList(Map<String, Object> map);

    List<User> findAdminList(Map<String, Object> map);
}
