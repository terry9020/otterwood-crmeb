package com.otterwood.common.acpect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
 * +----------------------------------------------------------------------
 * | OTTERWOOD [ OTTERWOOD赋能开发者，助力企业发展 ]
 * +----------------------------------------------------------------------
 * | Copyright (c) 2016~2025 https://www.otterwood.com All rights reserved.
 * +----------------------------------------------------------------------
 * | Licensed OTTERWOOD并不是自由软件，未经许可不能去掉OTTERWOOD相关版权
 * +----------------------------------------------------------------------
 * | Author: OTTERWOOD Team <admin@otterwood.com>
 * +----------------------------------------------------------------------
 * 所有的前端controller层的拦截业务，方法的执行时间长度，
 */
@Aspect
@Component
public class ControllerAspect {

    Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    @Pointcut("execution(* com.otterwood.otterwood.system.controller.*.*(..))")
    private void pointCutMethodController() {

    }

    @Around("pointCutMethodController()")
    public Object doAroundService(ProceedingJoinPoint pjp) throws Throwable {

        long begin = System.nanoTime();

        Object obj = pjp.proceed();

        long end = System.nanoTime();

        logger.info("Controller method：{}，prams：{}，cost time：{} ns，cost：{} ms",

                pjp.getSignature().toString(), Arrays.toString(pjp.getArgs()), (end - begin), (end - begin) / 1000000);

        return obj;
    }

}
