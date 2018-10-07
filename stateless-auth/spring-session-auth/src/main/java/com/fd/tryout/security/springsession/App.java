package com.fd.tryout.security.springsession;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fdanismaz
 * date: 10/7/18 8:34 PM
 */
@Slf4j
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
        log.info("Application started...");
    }
}
