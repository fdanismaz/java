package com.fd.tryout.eureka.controller;

import com.fd.eureka.dto.User;
import com.fd.tryout.eureka.client.FeignClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fdanismaz
 * date: 9/19/18 1:56 PM
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private FeignClients.UserClient userClient;

    @GetMapping("/{id}")
    public ResponseEntity<User> user(@PathVariable String id) {
        ResponseEntity<User> response = this.userClient.getUser(id);
        if (response.getStatusCode() == HttpStatus.OK) {
            log.error(response.getBody().toString());
            return ResponseEntity.ok().body(response.getBody());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

    }


}
