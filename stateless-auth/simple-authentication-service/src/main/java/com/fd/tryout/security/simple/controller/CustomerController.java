package com.fd.tryout.security.simple.controller;

import com.fd.tryout.security.dto.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fdanismaz
 * date: 10/7/18 12:40 PM
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping
    public List<Customer> list() {
        Customer c1 = Customer.builder()
                .id("1").name("john doe").company("acme").birthdate(LocalDate.now().minusYears(28)).build();
        Customer c2 = Customer.builder()
                .id("2").name("jane doe").company("acme").birthdate(LocalDate.now().minusYears(24)).build();
        List<Customer> result = new ArrayList<>();
        result.add(c1);
        result.add(c2);
        return result;
    }
}
