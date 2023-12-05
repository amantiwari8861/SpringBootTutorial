package com.testboot.practice1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/home")
    public String index()
    {
        return "index";
    }
    @GetMapping("/home2")
    public String index2()
    {
        return "index2";
    }
}