package com.example.thymeleaftest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController 
{
    @GetMapping("/index2")
    public String index2()
    {
        System.out.println("came in index2");
        return "index2";
    }
    @GetMapping("/")
    public String index(Model model)
    {
        System.out.println("came in /");
        model.addAttribute("username", "amantiwari8861");
        return "ind";
    }
}