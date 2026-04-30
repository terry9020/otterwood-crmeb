package com.otterwood.admin.config;

import com.otterwood.common.constants.Constants;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger / OpenAPI 3 配置组件（基于 springdoc-openapi + knife4j-openapi3）
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
@ConfigurationProperties(prefix = "api.doc")
public class SwaggerConfig {

    /** 是否开启 swagger，正式环境一般是需要关闭的，可根据 springboot 的多环境配置进行设置 */
    private Boolean swaggerEnabled = true;

    @Value("${server.port}")
    private String port;

    @Value("${otterwood.domain:}")
    private String domain;

    /**
     * 全局 OpenAPI 元信息 + 鉴权方案
     */
    @Bean
    public OpenAPI otterwoodOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Otterwood Java")
                        .description("Otterwood")
                        .version("1.0.0"))
                .addSecurityItem(new SecurityRequirement().addList(Constants.HEADER_AUTHORIZATION_KEY))
                .components(new Components()
                        .addSecuritySchemes(Constants.HEADER_AUTHORIZATION_KEY,
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.APIKEY)
                                        .in(SecurityScheme.In.HEADER)
                                        .name(Constants.HEADER_AUTHORIZATION_KEY)));
    }

    /** admin 分组：/api/admin/** */
    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group("admin")
                .packagesToScan("com.otterwood.admin")
                .pathsToMatch("/api/admin/**")
                .build();
    }

    /** public 分组：/api/public/** */
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .packagesToScan("com.otterwood.admin")
                .pathsToMatch("/api/public/**")
                .build();
    }

    public Boolean getSwaggerEnabled() {
        return swaggerEnabled;
    }

    public void setSwaggerEnabled(Boolean swaggerEnabled) {
        this.swaggerEnabled = swaggerEnabled;
    }
}
