package com.otterwood.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.otterwood.common.request.BargainFrontRequest;
import com.otterwood.common.request.PageParamRequest;
import com.otterwood.common.response.BargainRecordResponse;
import com.otterwood.common.response.BargainUserInfoResponse;
import com.github.pagehelper.PageInfo;
import com.otterwood.common.model.bargain.StoreBargainUser;
import com.otterwood.common.request.StoreBargainUserSearchRequest;
import com.otterwood.common.response.StoreBargainUserResponse;

import java.util.List;

/**
 * 用户参与砍价 Service
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
public interface StoreBargainUserService extends IService<StoreBargainUser> {

    PageInfo<StoreBargainUserResponse> getList(StoreBargainUserSearchRequest request, PageParamRequest pageParamRequest);

    /**
     * 获取砍价商品参与用户列表
     * @param bargainId 砍价商品Id
     * @return List<StoreBargainUser>
     */
    List<StoreBargainUser> getListByBargainId(Integer bargainId);

    /**
     * 获取用户砍价活动列表
     * @param bargainId 砍价商品编号
     * @param uid       参与用户uid
     * @return StoreBargainUser
     */
    List<StoreBargainUser> getListByBargainIdAndUid(Integer bargainId, Integer uid);

    /**
     * 砍价商品用户根据实体查询
     * @param bargainUser 砍价活动
     * @return List<StoreBargainUser>
     */
    List<StoreBargainUser> getByEntity(StoreBargainUser bargainUser);

    /**
     * 获取砍价成功列表Header
     */
    List<StoreBargainUser> getHeaderList();

    /**
     * 获取用户砍价信息
     * @param bargainFrontRequest 请求参数
     * @return BargainUserInfoResponse
     */
    BargainUserInfoResponse getBargainUserInfo(BargainFrontRequest bargainFrontRequest);

    /**
     * 砍价记录
     * @return PageInfo<BargainRecordResponse>
     */
    PageInfo<BargainRecordResponse> getRecordList(PageParamRequest pageParamRequest);
}
