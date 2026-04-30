package com.otterwood.admin.config;

import com.otterwood.admin.filter.JwtAuthenticationTokenFilter;
import com.otterwood.admin.manager.AuthenticationEntryPointImpl;
import com.otterwood.admin.manager.CustomAccessDeniedHandler;
import com.otterwood.admin.manager.CustomAuthenticationProvider;
import com.otterwood.common.constants.UploadConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.filter.CorsFilter;

/**
 * Security配置（Spring Security 6 / Spring Boot 3）
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
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig {

    /**
     * 跨域过滤器
     */
    @Autowired
    private CorsFilter corsFilter;

    /**
     * token认证过滤器
     */
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }

    /**
     * 认证失败处理类
     */
    @Bean
    public AuthenticationEntryPointImpl unauthorizedHandler() {
        return new AuthenticationEntryPointImpl();
    }

    /**
     * 鉴权失败处理类
     */
    @Bean
    public CustomAccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    /**
     * AuthenticationManager Bean，替代旧版本的 configure(AuthenticationManagerBuilder)。
     * 这里通过方法参数注入 Spring 容器中 @Component 声明的 CustomAuthenticationProvider，
     * 其内部依赖（UserDetailServiceImpl -> SystemAdminService/SystemMenuService）都会被 Spring 正确装配。
     * 不要在此处使用 new 构造 provider，否则将绕过依赖注入导致运行时 NPE。
     */
    @Bean
    public AuthenticationManager authenticationManager(CustomAuthenticationProvider customAuthenticationProvider) {
        return new ProviderManager(customAuthenticationProvider);
    }

    /**
     * anyRequest          |   匹配所有请求路径
     * access              |   SpringEl表达式结果为true时可以访问
     * anonymous           |   匿名可以访问
     * denyAll             |   用户不能访问
     * fullyAuthenticated  |   用户完全认证可以访问（非remember-me下自动登录）
     * hasAnyAuthority     |   如果有参数，参数表示权限，则其中任何一个权限可以访问
     * hasAnyRole          |   如果有参数，参数表示角色，则其中任何一个角色可以访问
     * hasAuthority        |   如果有参数，参数表示权限，则其权限可以访问
     * hasIpAddress        |   如果有参数，参数表示IP地址，如果用户IP和参数匹配，则可以访问
     * hasRole             |   如果有参数，参数表示角色，则其角色可以访问
     * permitAll           |   用户可以任意访问
     * rememberMe          |   允许通过remember-me登录的用户访问
     * authenticated       |   用户登录后可访问
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 启用 CORS，禁用 CSRF（基于 token，不使用 session）
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                // 认证/鉴权失败处理
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(unauthorizedHandler())
                        .accessDeniedHandler(accessDeniedHandler()))
                // 基于 token，不创建 session
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // 过滤请求
                .authorizeHttpRequests(auth -> auth
                        // 登录、验证码等放行
                        .requestMatchers("/api/admin/login", "/api/admin/validate/code/get").permitAll()
                        .requestMatchers("/api/admin/getLoginPic").permitAll()
                        .requestMatchers("/api/admin/login/account/detection").permitAll()
                        .requestMatchers("/api/admin/validate/code/getcaptchaconfig").permitAll()
                        // 放行资源路径
                        .requestMatchers("/" + UploadConstants.UPLOAD_FILE_KEYWORD + "/**").permitAll()
                        .requestMatchers("/" + UploadConstants.DOWNLOAD_FILE_KEYWORD + "/**").permitAll()
                        .requestMatchers("/" + UploadConstants.UPLOAD_AFTER_FILE_KEYWORD + "/**").permitAll()
                        // 放行图片、文件上传
                        .requestMatchers("/api/admin/upload/image").permitAll()
                        .requestMatchers("/api/admin/upload/file").permitAll()
                        // 静态资源（admin 为纯 REST 后端，不提供 html/css/js，原配置为历史冠余）
                        // 注意：Spring Security 6 下 requestMatchers(String) 采用 PathPattern，
                        // `**` 只允许出现在模式末尾；`/**/*.html` 这类写法不合法。
                        .requestMatchers(HttpMethod.GET, "/*.html").permitAll()
                        .requestMatchers("/profile/**").anonymous()
                        .requestMatchers("/common/download/**").anonymous()
                        .requestMatchers("/common/download/resource/**").anonymous()
                        // Swagger / knife4j
                        .requestMatchers("/doc.html").permitAll()
                        .requestMatchers("/swagger-resources/**").permitAll()
                        .requestMatchers("/webjars/**").permitAll()
                        .requestMatchers("/v2/**").permitAll()
                        .requestMatchers("/v3/**").permitAll()
                        .requestMatchers("/swagger-ui.html/**").permitAll()
                        .requestMatchers("/swagger-ui/**").permitAll()
                        .requestMatchers("/*/api-docs").anonymous()
                        .requestMatchers("/druid/**").anonymous()
                        .requestMatchers("/captcha/get", "/captcha/check").anonymous()
                        .requestMatchers("/api/admin/payment/callback/**").anonymous()
                        .requestMatchers("/api/public/**").permitAll()
                        // 除上面外的所有请求全部需要鉴权认证
                        .anyRequest().authenticated())
                // 防止 iframe 造成跨域
                .headers(headers -> headers.frameOptions(frame -> frame.disable()));

        // 添加 JWT filter（开启登录认证流程过滤器）
        http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        // 添加 CORS filter
        http.addFilterBefore(corsFilter, JwtAuthenticationTokenFilter.class);
        http.addFilterBefore(corsFilter, LogoutFilter.class);

        return http.build();
    }
}
