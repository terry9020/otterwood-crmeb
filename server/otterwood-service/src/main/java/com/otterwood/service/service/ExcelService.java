package com.otterwood.service.service;

import com.otterwood.common.request.StoreBargainSearchRequest;
import com.otterwood.common.request.StoreCombinationSearchRequest;
import com.otterwood.common.request.StoreOrderSearchRequest;
import com.otterwood.common.request.StoreProductSearchRequest;

/**
* StoreProductService 接口
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
public interface ExcelService{

    /**
     * 导出砍价商品
     * @param request 请求参数
     * @return 导出地址
     */
    String exportBargainProduct(StoreBargainSearchRequest request);

    /**
     * 导出拼团商品
     * @param request 请求参数
     * @return 导出地址
     */
    String exportCombinationProduct(StoreCombinationSearchRequest request);

    /**
     * 商品导出
     * @param request 请求参数
     * @return 导出地址
     */
    String exportProduct(StoreProductSearchRequest request);

    /**
     * 订单导出
     * @param request 查询条件
     * @return 文件名称
     */
    String exportOrder(StoreOrderSearchRequest request);
}
