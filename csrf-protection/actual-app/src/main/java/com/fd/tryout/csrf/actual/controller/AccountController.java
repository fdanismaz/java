package com.fd.tryout.csrf.actual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author furkand
 * 10/16/2018 3:41 PM
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    /**
     * This is a representative operation for demonstrating CSRF.
     *
     * To execute this method, you need to be authenticated. However, anohter site make
     * you send request to this handler and you may not be aware of it. You may click
     * a button, or an image so you will be the sender. The operation will be executed,
     * because this actual application will think you are the sender and you are authenticated.
     *
     * @return
     */
    @GetMapping
    public String transferMoney() {
        return "account";
    }

    @PostMapping("/transfer")
    public String transfer() {
        return "success";
    }
}
