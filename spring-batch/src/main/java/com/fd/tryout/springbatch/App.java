package com.fd.tryout.springbatch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author furkand
 * 10/26/2018 5:51 PM
 */
@Slf4j
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
        log.info("Application started...");
    }
}
