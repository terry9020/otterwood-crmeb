package com.otterwood.service.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.otterwood.common.request.PageParamRequest;
import com.otterwood.common.constants.BrokerageRecordConstants;
import com.otterwood.common.vo.UserFundsMonitor;
import com.github.pagehelper.PageInfo;
import com.otterwood.common.request.BrokerageRecordRequest;
import com.otterwood.common.model.user.User;
import com.otterwood.common.model.user.UserBrokerageRecord;
import com.otterwood.service.dao.UserFundsMonitorDao;
import com.otterwood.service.service.UserBrokerageRecordService;
import com.otterwood.service.service.UserFundsMonitorService;
import com.otterwood.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
* UserRechargeServiceImpl 接口实现
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
@Service
public class UserFundsMonitorServiceImpl extends ServiceImpl<UserFundsMonitorDao, UserFundsMonitor> implements UserFundsMonitorService {

    @Resource
    private UserFundsMonitorDao dao;

    @Autowired
    private UserBrokerageRecordService userBrokerageRecordService;

    @Autowired
    private UserService userService;

    /**
     * 佣金记录
     * @param request 筛选条件
     * @param pageParamRequest 分页参数
     * @return PageInfo
     */
    @Override
    public PageInfo<UserBrokerageRecord> getBrokerageRecord(BrokerageRecordRequest request, PageParamRequest pageParamRequest) {
        PageInfo<UserBrokerageRecord> pageInfo = userBrokerageRecordService.getAdminList(request, pageParamRequest);
        List<UserBrokerageRecord> list = pageInfo.getList();
        if (CollUtil.isEmpty(list)) {
            pageInfo.setList(list);
            return pageInfo;
        }
        List<Integer> uidList = list.stream().map(e -> e.getUid()).distinct().collect(Collectors.toList());
        HashMap<Integer, User> userMap = userService.getMapListInUid(uidList);
        list.forEach(e -> {
            if (e.getLinkType().equals(BrokerageRecordConstants.BROKERAGE_RECORD_LINK_TYPE_WITHDRAW)
                    && e.getStatus().equals(BrokerageRecordConstants.BROKERAGE_RECORD_STATUS_COMPLETE)
                    && e.getType().equals(BrokerageRecordConstants.BROKERAGE_RECORD_TYPE_SUB)) {
                e.setTitle("提现成功");
            }
            String name = "-";
            if(ObjectUtil.isNotNull(userMap.get(e.getUid()))){
                name = userMap.get(e.getUid()).getNickname();
            }
            e.setUserName(name);
        });
        pageInfo.setList(list);
        return pageInfo;
    }


}

