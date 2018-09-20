package com.fd.tryout.hystrix.eureka.feign.client.user;

import com.fd.tryout.hystrix.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author fdanismaz
 * date: 9/20/18 11:37 AM
 */
public class UserFeignClients {

    @FeignClient("${fd.microservice.user.name}")
    public interface UserClient {

        @GetMapping("/test/user/{id}")
        ResponseEntity<User> getUser(@PathVariable("id") String id);

    }
}
