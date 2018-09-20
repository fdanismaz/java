package com.fd.tryout.hystrix.eureka.feign.client.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author fdanismaz
 * date: 9/20/18 11:10 AM
 */
@Slf4j
@Configuration
@EnableEurekaClient
@ComponentScan("com.fd.tryout")
public class EurekaConfiguration {

    @PostConstruct
    public void init() {
        log.info("Eureka configuration constructed");
    }
}
