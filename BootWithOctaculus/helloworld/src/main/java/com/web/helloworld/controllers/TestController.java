package com.web.helloworld.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// @RestController
public class TestController 
{
    @GetMapping("/hi")	
    public String sayHi()
	{
		return "Hello World";
	}
	@GetMapping("/")
	public String index(Model model)
	{
		model.addAttribute("current", new Date());
		return "index";
	}
}
