package com.fd.tryout.hystrix.dto.eureka.client.controller;

import com.fd.tryout.hystrix.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fdanismaz
 * date: 9/20/18 11:03 AM
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        User user = User.builder().id("1").name("John Doe").email("john.doe@gmail.com").build();
        return ResponseEntity.ok().body(user);
    }
}
