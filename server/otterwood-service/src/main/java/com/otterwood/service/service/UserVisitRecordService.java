package com.otterwood.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.otterwood.common.model.record.UserVisitRecord;

/**
 * UserVisitRecordService 接口
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
public interface UserVisitRecordService extends IService<UserVisitRecord> {

    /**
     * 通过日期获取浏览量
     * @param date 日期
     * @return Integer
     */
    Integer getPageviewsByDate(String date);

    /**
     * 通过时间段获取浏览量
     * @param startDate 日期
     * @param endDate 日期
     * @return Integer
     */
    Integer getPageviewsByPeriod(String startDate, String endDate);

    /**
     * 通过日期获取活跃用户数
     * @param date 日期
     * @return Integer
     */
    Integer getActiveUserNumByDate(String date);

    /**
     * 通过时间段获取活跃用户数
     * @param startDate 日期
     * @param endDate 日期
     * @return Integer
     */
    Integer getActiveUserNumByPeriod(String startDate, String endDate);
}
