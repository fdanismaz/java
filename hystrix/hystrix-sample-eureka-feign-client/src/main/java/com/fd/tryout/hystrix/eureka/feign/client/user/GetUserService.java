package com.fd.tryout.hystrix.eureka.feign.client.user;

import com.fd.tryout.hystrix.dto.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author fdanismaz
 * date: 9/20/18 12:28 PM
 */
@Slf4j
@Service
public class GetUserService {

    private static final String UserCacheKey = "UserCache";

    @Autowired
    private UserFeignClients.UserClient userClient;

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    private HashOperations<String, String, User> userCache;

    @PostConstruct
    public void init() {
        this.userCache = redisTemplate.opsForHash();
    }

    @HystrixCommand(fallbackMethod = "readUserFromCache", commandKey = "GetUser", threadPoolKey = "GetUserFromEndpoint")
    public User getUser(String userId) {
        log.debug("Sending request to endpoint");
        ResponseEntity<User> response = this.userClient.getUser(userId);
        if (response.getStatusCode() == HttpStatus.OK) {
            log.debug("Request successful");
            User user = response.getBody();
            this.updateCache(user);
            return user;
        } else {
            log.error("Cannot access user endpoint");
            throw new RuntimeException("Exception: Cannot access user endpoint");
        }
    }

    @HystrixCommand(fallbackMethod = "defaultFallback", commandKey = "GetUser", threadPoolKey = "GetUserFromCache")
    private User readUserFromCache(String userId) {
        log.debug("Reading user from cache");
        return userCache.get(UserCacheKey, userId);
    }

    private User defaultFallback(String userId) {
        log.error("Cannot read user from cache with the id: " + userId);
        log.debug("Returning null user");
        return null;
    }

    private void updateCache(User user) {
        try {
            log.debug("Updating cache...");
            userCache.put(UserCacheKey, user.getId(), user);
        }
        catch (Throwable e) {
            log.error("Cannot update cache", e);
        }
    }
}
