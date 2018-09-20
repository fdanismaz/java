package com.fd.tryout.hystrix.eureka.feign.client.config;

import com.fd.tryout.hystrix.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author fdanismaz
 * date: 9/20/18 12:08 PM
 */
@EnableCaching
@Configuration
public class CachingConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public RedisTemplate<String, User> userRedisTemplate() {
        RedisTemplate<String, User> userRedisTemplate = new RedisTemplate<>();
        userRedisTemplate.setConnectionFactory(this.redisConnectionFactory);
        userRedisTemplate.setEnableTransactionSupport(true);
        return userRedisTemplate;
    }
}
