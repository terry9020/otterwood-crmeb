package com.otterwood.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 程序主入口
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
@EnableAsync //开启异步调用
@Configuration
@EnableTransactionManagement
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //去掉数据源
//@ComponentScan(basePackages={"com.utils",
//        "com.otterwood.otterwood",
//        "com.exception",
//        "com.common",
//        "com.aop"}) //扫描utils包和父包
//@MapperScan(basePackages = {"com.otterwood.otterwood.*.dao", "com.otterwood.otterwood.*.*.dao"})
@ComponentScan(basePackages = {"com.otterwood"})
@MapperScan(basePackages = {"com.otterwood.**.dao"})
public class OtterwoodAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(OtterwoodAdminApplication.class, args);
    }

}
