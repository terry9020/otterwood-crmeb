package com.otterwood.service.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.otterwood.common.exception.OtterwoodException;
import com.otterwood.common.model.sms.SmsTemplate;
import com.otterwood.service.dao.SmsTemplateDao;
import com.otterwood.service.service.SmsTemplateService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

/**
 * SmsTemplateServiceImpl 接口实现
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
public class SmsTemplateServiceImpl extends ServiceImpl<SmsTemplateDao, SmsTemplate> implements SmsTemplateService {

    @Resource
    private SmsTemplateDao dao;

    /**
     * 获取详情
     * @param id 模板id
     * @return SmsTemplate
     */
    @Override
    public SmsTemplate getDetail(Integer id) {
        SmsTemplate smsTemplate = getById(id);
        if (ObjectUtil.isNull(smsTemplate)) {
            throw new OtterwoodException("短信模板不存在");
        }
        return smsTemplate;
    }
}

