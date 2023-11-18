package com.mysecurity.spsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/employee")
    public String employee(){
        return "employee";
    }

    @GetMapping("/manager")
    public String manager(){
        return "manager";
    }
}
