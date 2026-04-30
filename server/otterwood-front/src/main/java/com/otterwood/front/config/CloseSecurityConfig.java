package com.otterwood.front.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Front 端不启用 Spring Security 认证（全放行）。
 * Spring Security 6 / Spring Boot 3 写法：基于 SecurityFilterChain Bean。
 */
@Configuration
@EnableWebSecurity
public class CloseSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                .logout(Customizer.withDefaults());
        return http.build();
    }
}
