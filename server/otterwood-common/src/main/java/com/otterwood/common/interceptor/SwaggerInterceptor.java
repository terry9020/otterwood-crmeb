package com.otterwood.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 *  Swagger 文档拦截器
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
public class SwaggerInterceptor implements HandlerInterceptor {
    private final String username;
    private final String password;
    private final Boolean check;

    public SwaggerInterceptor(String username, String password, Boolean check) {
        this.username = username;
        this.password = password;
        this.check = check;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        boolean isAuthSuccess = httpBasicAuth(authorization);
        if (!isAuthSuccess) {
            response.setCharacterEncoding("utf-8");
            response.setStatus(401);
            response.setHeader("WWW-authenticate", "Basic realm=\"Realm\"");
            try (PrintWriter writer = response.getWriter()) {
                writer.print("Forbidden, unauthorized user");
            }
        }
        return isAuthSuccess;
    }

    public boolean httpBasicAuth(String authorization) throws IOException {
        if (Boolean.TRUE.equals(check)) {
            if (authorization != null && authorization.split(" ").length == 2) {
                String userAndPass = new String(
                        Base64.getDecoder().decode(authorization.split(" ")[1]),
                        StandardCharsets.UTF_8);
                String[] parts = userAndPass.split(":");
                if (parts.length != 2) {
                    return false;
                }
                return this.username.equals(parts[0]) && this.password.equals(parts[1]);
            }
            return false;
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String uri = request.getRequestURI();
        AntPathMatcher pathMatcher = new AntPathMatcher();
        if (!pathMatcher.match("/swagger-ui.html", uri) && !pathMatcher.match("/webjars/**", uri)) {
            response.setStatus(404);
            return;
        }
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:/META-INF/resources" + uri);
        if (resources.length > 0) {
            FileCopyUtils.copy(resources[0].getInputStream(), response.getOutputStream());
        } else {
            response.setStatus(404);
        }
    }
}
