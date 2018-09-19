package com.fd.tryout.eureka.client;

import com.fd.eureka.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author fdanismaz
 * date: 9/19/18 1:42 PM
 */
public class FeignClients {

    @FeignClient("${fd.microservice.user.name}")
    public interface UserClient {

        @GetMapping("/test/user/{id}")
        ResponseEntity<User> getUser(@PathVariable("id") String id);

    }
}
