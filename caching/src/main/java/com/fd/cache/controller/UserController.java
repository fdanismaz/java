package com.fd.cache.controller;

import com.fd.cache.model.User;
import com.fd.cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fdanismaz
 * date: 9/18/18 10:39 AM
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<User> user(@PathVariable int id) {
        System.out.println("In controller...");
        return ResponseEntity.ok(this.service.getUser(id));
    }
}