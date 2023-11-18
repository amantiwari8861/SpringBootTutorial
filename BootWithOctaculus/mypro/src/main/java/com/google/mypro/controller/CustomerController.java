package com.google.mypro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    @GetMapping("/customers-list")
    public String customers_list(){
        return "customers-list";
    }

    @GetMapping("/create-customer")
    public String create_customer(){
        return "create-customer";
    }
}
