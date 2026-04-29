package com.otterwood.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.otterwood.common.request.PageParamRequest;
import com.otterwood.common.model.user.UserExperienceRecord;

import java.util.List;

/**
 * 用户经验记录服务接口
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
public interface UserExperienceRecordService extends IService<UserExperienceRecord> {

    /**
     * 获取用户经验列表（移动端）
     * @param userId 用户id
     * @param pageParamRequest 分页参数
     * @return List
     */
    List<UserExperienceRecord> getH5List(Integer userId, PageParamRequest pageParamRequest);

    /**
     * 通过订单编号获取记录
     * @param orderNo 订单编号
     * @param uid uid
     * @return UserExperienceRecord
     */
    UserExperienceRecord getByOrderNoAndUid(String orderNo, Integer uid);
}
