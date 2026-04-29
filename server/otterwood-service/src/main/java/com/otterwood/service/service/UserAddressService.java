package com.otterwood.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.otterwood.common.request.PageParamRequest;
import com.otterwood.common.model.user.UserAddress;
import com.otterwood.common.request.UserAddressRequest;

import java.util.List;

/**
 * UserAddressService 接口实现
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
public interface UserAddressService extends IService<UserAddress> {

    /**
     * 用户地址列表
     * @param pageParamRequest 分页参数
     * @return List<UserAddress>
     */
    List<UserAddress> getList(PageParamRequest pageParamRequest);

    /**
     * 添加用户地址
     * @param request 地址请求参数
     * @return UserAddress
     */
    UserAddress create(UserAddressRequest request);

    /**
     * 设置默认地址
     * @param id 地址id
     * @return Boolean
     */
    Boolean def(Integer id);

    /**
     * 删除用户地址
     * @param id 地址id
     * @return Boolean
     */
    Boolean delete(Integer id);

    UserAddress getDefault();

    UserAddress getById(Integer addressId);

    /**
     * 获取地址详情
     * @param id 地址id
     * @return UserAddress
     */
    UserAddress getDetail(Integer id);

    /**
     * 获取默认地址
     * @return UserAddress
     */
    UserAddress getDefaultByUid(Integer uid);
}
