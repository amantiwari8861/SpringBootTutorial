package com.learn.restcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

    @GetMapping("/")
    public String index() {
        return "Hello world";
    }
    @GetMapping("/user")
    public String user()
    {
        return "Hello user or Admin !!";
    }
    @GetMapping("/admin")
    public String admin()
    {
        return "Hello Admin!!";
    }
    
    @GetMapping("/seller")
    public String seller()
    {
        return "Hello Seller or Admin!!";
    }
    
}