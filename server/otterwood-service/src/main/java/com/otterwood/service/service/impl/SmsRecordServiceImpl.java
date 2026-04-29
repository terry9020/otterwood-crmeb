package com.otterwood.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.otterwood.common.model.sms.SmsRecord;
import com.otterwood.service.dao.SmsRecordDao;
import com.otterwood.service.service.SmsRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * SmsRecordServiceImpl 接口实现
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
@Service
public class SmsRecordServiceImpl extends ServiceImpl<SmsRecordDao, SmsRecord> implements SmsRecordService {

    @Resource
    private SmsRecordDao dao;

    /**
     * 短信发送记录保存
     *
     * @param smsRecord 待保存短信记录
     * @return 保存结果
     */
    @Override
    public boolean save(SmsRecord smsRecord) {
        return dao.insert(smsRecord) > 0;
    }
}

