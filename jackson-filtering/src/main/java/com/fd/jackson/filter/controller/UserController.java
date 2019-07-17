package com.fd.jackson.filter.controller;

import com.fd.jackson.filter.model.GenericResponse;
import com.fd.jackson.filter.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<User>> getUser(@PathVariable int id) {
        User user = User.builder()
                .firstName("furkan")
                .lastName("danismaz")
                .email("danismaz.furkan@gmail.com")
                .password("123456")
                .build();
        return ResponseEntity.ok().body(GenericResponse.success(user));
    }

    @PostMapping
    public ResponseEntity<GenericResponse<User>> create(@RequestBody User user) {
        System.out.println("Password is " + user.getPassword());
        return ResponseEntity.ok().body(GenericResponse.success(user));
    }
}
