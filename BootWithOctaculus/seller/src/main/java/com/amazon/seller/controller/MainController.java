package com.amazon.seller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    
    @RequestMapping(value = "/about",method = RequestMethod.GET)
    public String about(){
        return "about";
    }

    @RequestMapping(value = "/contact",method = RequestMethod.GET)
    public String contact(){
        return "contact";
    }

    @RequestMapping(value = "/signin",method = RequestMethod.GET)
    public String signin(){
        return "signin";
    }

    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    public String signup(){
        return "signup";
    }


}
