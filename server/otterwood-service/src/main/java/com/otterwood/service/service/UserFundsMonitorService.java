package com.otterwood.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.otterwood.common.request.PageParamRequest;
import com.otterwood.common.vo.UserFundsMonitor;
import com.github.pagehelper.PageInfo;
import com.otterwood.common.request.BrokerageRecordRequest;
import com.otterwood.common.model.user.UserBrokerageRecord;

/**
*  UserRechargeService 接口
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
public interface UserFundsMonitorService extends IService<UserFundsMonitor> {

    /**
     * 佣金记录
     * @param request 筛选条件
     * @param pageParamRequest 分页参数
     * @return PageInfo
     */
    PageInfo<UserBrokerageRecord> getBrokerageRecord(BrokerageRecordRequest request, PageParamRequest pageParamRequest);
}
