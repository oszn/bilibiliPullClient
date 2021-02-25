package com.myLogger.component.cache.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisCacheTemplateConfig extends redisConfig{
    @Value("${spring.redis.cache.host}")
    private String host;
    @Value("${spring.redis.cache.port}")
    private Integer port;
    @Value("${spring.redis.cache.password}")
    private String password;

    @Bean()
    public RedisConnectionFactory cacheRedisConnectionFactory() {
        return createConnectionFactory(host, port, password);
    }

    @Bean(RedisTemplateConstant.CacheRedisTemplate)
    public RedisTemplate<String, String> redisTemplate(){
        RedisTemplate<String, String> redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(cacheRedisConnectionFactory());
        return redisTemplate;
    }
}
