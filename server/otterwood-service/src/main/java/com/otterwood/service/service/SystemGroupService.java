package com.otterwood.service.service;

import com.otterwood.common.request.PageParamRequest;
import com.otterwood.common.model.system.SystemGroup;
import com.baomidou.mybatisplus.extension.service.IService;
import com.otterwood.common.request.SystemGroupRequest;
import com.otterwood.common.request.SystemGroupSearchRequest;

import java.util.List;

/**
 * SystemGroupService 接口
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
public interface SystemGroupService extends IService<SystemGroup> {

    /**
     * 分页显示组合数据表
     * @param request 搜索条件
     * @param pageParamRequest 分页参数
     */
    List<SystemGroup> getList(SystemGroupSearchRequest request, PageParamRequest pageParamRequest);

    /**
     * 新增组合数据
     * @param systemGroupRequest 新增参数
     */
    Boolean add(SystemGroupRequest systemGroupRequest);

    /**
     * 删除组合数据表
     * @param id Integer
     */
    Boolean delete(Integer id);

    /**
     * 修改组合数据表
     * @param id integer id
     * @param systemGroupRequest 修改参数
     */
    Boolean edit(Integer id, SystemGroupRequest systemGroupRequest);
}
