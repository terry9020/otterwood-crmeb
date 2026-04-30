package com.otterwood.common.config;

import com.anji.captcha.config.AjCaptchaServiceAutoConfiguration;
import com.anji.captcha.config.AjCaptchaStorageAutoConfiguration;
import com.anji.captcha.properties.AjCaptchaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * aj-captcha 1.3.0 兼容 Spring Boot 3 的桥接配置。
 * <p>
 * 背景：aj-captcha:1.3.0 通过 META-INF/spring.factories 注册 AutoConfiguration，
 * Spring Boot 3 已废弃该机制，只识别
 * META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports。
 * 升级后 AjCaptchaAutoConfiguration 不再被 Spring Boot 自动发现，导致
 * {@code com.anji.captcha.service.CaptchaService} Bean 未注册，启动抛
 * NoSuchBeanDefinitionException。
 * <p>
 * 策略：
 * <ul>
 *   <li>不直接 @Import 官方 AjCaptchaAutoConfiguration，因为它使用
 *       {@code @ComponentScan("com.anji.captcha")} 会连带加载依赖
 *       {@code javax.servlet.*} 的 CaptchaController（SB3 环境下只有 jakarta.servlet，
 *       会触发 ClassNotFoundException）。</li>
 *   <li>直接 @Import 两个与 servlet 无关的子配置：Service 配置（注册 CaptchaService）、
 *       Storage 配置（注册 CaptchaCacheService）。</li>
 *   <li>通过 @EnableConfigurationProperties 显式激活配置属性绑定。</li>
 *   <li>Controller 层由本项目自定义的 SafetyController 负责，不依赖原生
 *       CaptchaController。</li>
 * </ul>
 */
@Configuration
@EnableConfigurationProperties(AjCaptchaProperties.class)
@Import({AjCaptchaServiceAutoConfiguration.class, AjCaptchaStorageAutoConfiguration.class})
public class AjCaptchaConfig {
}
