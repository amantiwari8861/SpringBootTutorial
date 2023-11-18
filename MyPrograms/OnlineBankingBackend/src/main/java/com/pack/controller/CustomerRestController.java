package com.pack.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.entity.Customers;

@RestController
@RequestMapping("api/bank")
public class CustomerRestController
{
	@GetMapping("/hello")
	public String sayHello()
	{
		return "hello Aman";
	}
	
	@GetMapping("/customer")
	public Customers getCustomer()
	{
		return new Customers("Aman", 101, 9891062743l, 56000.899);
	}
	
	@GetMapping("/customers")
	public List<Customers> getAllCustomers()
	{
		return List.of(new Customers("Aman", 101, 9891062743l, 56000.899),new Customers("Aman2", 101, 9891062743l, 56000.899));
	}
}
