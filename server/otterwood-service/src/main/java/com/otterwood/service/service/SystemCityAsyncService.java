package com.otterwood.service.service;

/**
 * SystemCityAsyncService 接口
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
public interface SystemCityAsyncService {

    /**
     * 数据整体刷入redis
     */
    void async(Integer id);

    /**
     * 设置属性列表进入redis
     */
    void setListTree();
}
