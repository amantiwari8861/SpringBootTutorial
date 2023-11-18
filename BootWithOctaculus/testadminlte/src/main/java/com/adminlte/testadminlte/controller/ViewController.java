package com.adminlte.testadminlte.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    
    @GetMapping(value = {"/","/index.html"})
    String getIndex()
    {
        return "/view/index.jsp";
    }
    
    @GetMapping(value = {"/index3","/third"})
    String getIndex3()
    {
        return "index3.html";
    }
    
    @GetMapping("/index2")
    String getIndex2()
    {
        return "index2.html";
    }
}
    
