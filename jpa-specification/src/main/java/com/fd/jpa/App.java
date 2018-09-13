package com.fd.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;

/**
 * @author furkan.danismaz
 * 10/09/2018 11:12
 */
@SpringBootApplication
@ComponentScan("com.fd")
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
