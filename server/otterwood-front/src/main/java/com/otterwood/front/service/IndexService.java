package com.otterwood.front.service;

import com.otterwood.common.model.system.SystemConfig;
import com.otterwood.common.page.CommonPage;
import com.otterwood.common.request.PageParamRequest;
import com.otterwood.common.response.CopyrightConfigInfoResponse;
import com.otterwood.common.response.IndexInfoResponse;
import com.otterwood.common.response.IndexProductResponse;
import com.otterwood.common.response.pagelayout.PageLayoutBottomNavigationResponse;
import com.otterwood.common.vo.MyRecord;

import java.util.HashMap;
import java.util.List;

/**
* IndexService 接口
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
public interface IndexService{

    /**
     * 首页信息
     * @return IndexInfoResponse
     */
    IndexInfoResponse getIndexInfo();

    /**
     * 热门搜索
     * @return List
     */
    List<HashMap<String, Object>> hotKeywords();

    /**
     * 分享配置信息
     */
    HashMap<String, String> getShareConfig();

    /**
     * 获取首页商品列表
     * @param type 类型 【1 精品推荐 2 热门榜单 3首发新品 4促销单品】
     * @param pageParamRequest 分页参数
     * @return List
     */
    CommonPage<IndexProductResponse> findIndexProductList(Integer type, PageParamRequest pageParamRequest);

    /**
     * 获取颜色配置
     * @return SystemConfig
     */
    SystemConfig getColorConfig();

    /**
     * 获取版本信息
     * @return MyRecord
     */
    MyRecord getVersion();

    /**
     * 获取全局本地图片域名
     * @return String
     */
    String getImageDomain();

    /**
     * 获取公司版权图片
     */
    CopyrightConfigInfoResponse getCopyrightInfo();

    /**
     * 获取底部导航信息
     */
    PageLayoutBottomNavigationResponse getBottomNavigationInfo();
}
