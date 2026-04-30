package com.otterwood.common.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.convert.DurationStyle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.Objects;

/**
 * Redis配置组件
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
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Value("${spring.redis.password}")
    private String redisPass;

    @Value("${spring.redis.database}")
    private int redisDb;

    @Value("${spring.redis.timeout}")
    private String timeout;

    @Value("${spring.redis.lettuce.pool.max-active}")
    private int maxTotal;

    @Value("${spring.redis.lettuce.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.lettuce.pool.min-idle}")
    private int minIdle;

    @Value("${spring.redis.lettuce.pool.max-wait}")
    private int maxWaitMillis;

    @Value("${spring.redis.lettuce.pool.time-between-eviction-runs}")
    private String timeBetweenEvictionRunsMillis;

    @Value("${spring.redis.lettuce.pool.test-on-borrow:false}")
    private boolean testOnBorrow;

    @Value("${spring.redis.lettuce.pool.test-while-idle:false}")
    private boolean testWhileIdle;

    @Value("${spring.redis.second.database}")
    private int redisSecondDatabase;

    @Bean(name = "redisConnectionFactory")
    @Primary  //默认选择这个数据源进行执行
    @Qualifier("redisConnectionFactory")
    public RedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setPort(redisPort);
        config.setHostName(redisHost);
        config.setDatabase(redisDb);
        config.setPassword(resolveRedisPassword(redisPass));
        LettuceClientConfiguration lettuceClientConfiguration = LettucePoolingClientConfiguration.builder()
                .poolConfig(lettucePoolConfig())
                .commandTimeout(parseDuration(timeout))
                .shutdownTimeout(Duration.ZERO)
                .build();
        return new LettuceConnectionFactory(config, lettuceClientConfiguration);
    }

    @Bean(name = "secondRedisConnectionFactory")
    @Qualifier("secondRedisConnectionFactory")
    public RedisConnectionFactory secondRedisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setPort(redisPort);
        config.setHostName(redisHost);
        config.setDatabase(redisSecondDatabase);
        config.setPassword(resolveRedisPassword(redisPass));
        LettuceClientConfiguration lettuceClientConfiguration = LettucePoolingClientConfiguration.builder()
                .poolConfig(lettucePoolConfig())
                .commandTimeout(parseDuration(timeout))
                .shutdownTimeout(Duration.ZERO)
                .build();
        return new LettuceConnectionFactory(config, lettuceClientConfiguration);
    }

    @Bean(name = "redisTemplate")
    @Primary
    public RedisTemplate<String, Object> redisTemplate(
            @Qualifier("redisConnectionFactory") RedisConnectionFactory redisConnectionFactory) {
        return buildRedisTemplate(redisConnectionFactory);
    }

    @Bean(name = "secondRedisTemplate")
    public RedisTemplate<String, Object> secondRedisTemplate(
            @Qualifier("secondRedisConnectionFactory") RedisConnectionFactory secondRedisConnectionFactory) {
        return buildRedisTemplate(secondRedisConnectionFactory);
    }

    private GenericObjectPoolConfig<?> lettucePoolConfig() {
        GenericObjectPoolConfig<?> poolConfig = new GenericObjectPoolConfig<>();
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMaxWait(Duration.ofMillis(maxWaitMillis));
        poolConfig.setMinIdle(minIdle);
        poolConfig.setTimeBetweenEvictionRuns(parseDuration(timeBetweenEvictionRunsMillis));
        poolConfig.setTestOnBorrow(testOnBorrow);
        poolConfig.setTestWhileIdle(testWhileIdle);
        return poolConfig;
    }

    private RedisPassword resolveRedisPassword(String password) {
        if (Objects.isNull(password) || password.trim().isEmpty()) {
            return RedisPassword.none();
        }
        return RedisPassword.of(password);
    }

    /**
     * 兼容 "30000"（毫秒）与 "30s"/"1m" 等 Spring Duration 风格。
     */
    private Duration parseDuration(String value) {
        String source = value == null ? "" : value.trim();
        if (source.isEmpty()) {
            return Duration.ZERO;
        }
        if (source.chars().allMatch(Character::isDigit)) {
            return Duration.ofMillis(Long.parseLong(source));
        }
        return DurationStyle.detectAndParse(source);
    }

    private RedisTemplate<String, Object> buildRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        StringRedisSerializer stringSerializer = new StringRedisSerializer();
        GenericJackson2JsonRedisSerializer jackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

}


