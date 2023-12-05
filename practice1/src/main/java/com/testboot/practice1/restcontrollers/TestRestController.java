package com.testboot.practice1.restcontrollers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @GetMapping("/hi")
    public String greet()
    {
        return "Hello world!!";
    }
}
//15.206.124.202