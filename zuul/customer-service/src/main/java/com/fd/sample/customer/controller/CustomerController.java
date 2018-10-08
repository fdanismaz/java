package com.fd.sample.customer.controller;

import com.fd.sample.customer.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author furkand
 * 10/8/2018 9:59 AM
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @GetMapping
    public List<Customer> customerList() {
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
