package com.fd.tryout.hystrix.eureka.feign.client.config;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Configuration;

/**
 * @author fdanismaz
 * date: 9/20/18 2:08 PM
 */
@EnableCircuitBreaker
@Configuration
public class HystrixConfiguration {
}
