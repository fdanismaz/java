package com.fd.spring.cloud.config.vault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author fdanismaz
 * date: 2/7/19 1:45 AM
 */
@SpringBootApplication
@EnableConfigServer
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
