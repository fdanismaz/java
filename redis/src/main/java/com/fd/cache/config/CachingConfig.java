package com.fd.cache.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * @author fdanismaz
 * date: 9/18/18 10:36 AM
 */
@EnableCaching
@Configuration
public class CachingConfig {
//      Below code is not needed thanks to Spring-Boot
//
//    @Autowired
//    private Environment env;
//
//    @Bean
//    public LettuceConnectionFactory redisConnectionFactory() {
//        RedisStandaloneConfiguration redisConf = new RedisStandaloneConfiguration();
//        redisConf.setHostName(env.getProperty("spring.redis.host"));
//        redisConf.setPort(Integer.parseInt(env.getProperty("spring.redis.port")));
//        redisConf.setPassword(RedisPassword.of(env.getProperty("spring.redis.password")));
//        return new LettuceConnectionFactory(redisConf);
//    }
//    @Bean
//    public RedisCacheConfiguration cacheConfiguration() {
//        RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofSeconds(600))
//                .disableCachingNullValues();
//        return cacheConfig;
//    }
//    @Bean
//    public RedisCacheManager cacheManager() {
//        RedisCacheManager rcm = RedisCacheManager.builder(redisConnectionFactory())
//                .cacheDefaults(cacheConfiguration())
//                .transactionAware()
//                .build();
//        return rcm;
//    }

}