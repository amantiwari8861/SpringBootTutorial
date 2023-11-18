package com.learn.restcontrollers;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController 
{
    // @GetMapping("/")
	// public String welcome()
	// {
	// 	return "Welcome to HomePage!!";
	// }

	@GetMapping("/user")
	public Principal user(Principal principal)
	{
        try 
        {
            System.out.println(principal.getName());
        } 
		catch (Exception e) 
        {
            System.out.println(e.getLocalizedMessage());
        }
		return principal;
	}
}
