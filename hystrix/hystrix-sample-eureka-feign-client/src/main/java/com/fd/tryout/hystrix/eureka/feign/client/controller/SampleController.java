package com.fd.tryout.hystrix.eureka.feign.client.controller;

import com.fd.tryout.hystrix.dto.User;
import com.fd.tryout.hystrix.eureka.feign.client.user.GetUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fdanismaz
 * date: 9/20/18 11:13 AM
 */
@Slf4j
@RestController
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    private GetUserService getUserService;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> user(@PathVariable String id) {
        log.debug("Inside request");
        return ResponseEntity.ok().body(this.getUserService.getUser(id));
    }


}