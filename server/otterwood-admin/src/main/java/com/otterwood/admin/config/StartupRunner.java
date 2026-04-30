package com.otterwood.admin.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 应用启动完成后的初始化任务入口。
 * <p>
 * 二开版：已移除 CRMEB 官方"安装统计上报"逻辑（原会向 shop.crmeb.net 发送当前域名/版本，
 * 二开场景下该域名不可达，且不具业务价值，故整体删除）。
 * 如后续需要增加启动后初始化任务，直接在 {@link #run(String...)} 中扩展即可。
 */
@Component
public class StartupRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("项目启动完成，初始化任务执行结束...");
    }
}
