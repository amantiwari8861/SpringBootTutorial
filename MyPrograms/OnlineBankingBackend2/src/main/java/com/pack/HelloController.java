package com.pack;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController 
{
    @RequestMapping("/")
    @ResponseBody
    String hello()
    {
        return "Hello Aman Sir!";
    }
}
