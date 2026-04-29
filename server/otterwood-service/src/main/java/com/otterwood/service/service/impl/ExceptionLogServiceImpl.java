package com.otterwood.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.otterwood.common.model.exception.ExceptionLog;
import com.otterwood.service.dao.ExceptionLogDao;
import com.otterwood.service.service.ExceptionLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ExceptionLogServiceImpl 接口实现
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
public class ExceptionLogServiceImpl extends ServiceImpl<ExceptionLogDao, ExceptionLog> implements ExceptionLogService {

    @Resource
    private ExceptionLogDao dao;

}

