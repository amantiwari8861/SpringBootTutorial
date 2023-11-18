package com.learn.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2")
public class TestSecurityController {

	@GetMapping("/hello")
	String hello()
	{
		return "hello bro";
	}
	
//	@PreAuthorize("hasRole('ADMIN')") //In DB ROLE_ADMIN is compulsory
//	@PreAuthorize("hasRole('USER')") //In DB ROLE_ADMIN is compulsory
	@PreAuthorize("hasRole('Manager')") //In DB ROLE_Manager is compulsory
	@DeleteMapping("/del")
	String del()
	{
		return "deleting bro";
	}
}
