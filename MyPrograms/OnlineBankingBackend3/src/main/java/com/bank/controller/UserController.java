package com.bank.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.Customer;
import com.bank.service.UserService;

@RestController// @Controller + @ResponseBody
@RequestMapping("/api")
@CrossOrigin(value = "*")
//@CrossOrigin(value = {"http://localhost:4200","http://localhost:3000"})
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/users")
	public List<Customer> findAllUsers() {
		return service.getAllUsers();
	}
	
	@PostMapping("/users")
	public ResponseEntity<Customer> registerUser(@RequestBody Customer user) 
	{
		Customer user2 = service.saveUser(user);
		return ResponseEntity.ok(user2); //200
	}
	
	@PutMapping("/users")
	public ResponseEntity<Customer> updateUser(@RequestBody Customer user) {
		Customer user2 = service.saveUser(user);
		return ResponseEntity.ok(user2); //200
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
		Boolean user = service.deleteUser(id);
		return ResponseEntity.ok(user); //200
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<Customer> getUserById(@PathVariable Long id) {
		Customer user = service.getUserById(id);
		return ResponseEntity.ok(user); //200
	}
	@GetMapping("/users/by-accountno/{accountNumber}")
	public ResponseEntity<Customer> getUserByAadhar(@PathVariable Long accountNumber) {
		Customer user = service.getUserByAccountNumber(accountNumber);
		return ResponseEntity.ok(user); //200
	}
	
}
