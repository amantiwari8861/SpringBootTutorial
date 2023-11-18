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
import com.bank.entity.Employee;
import com.bank.service.EmployeeService;


@RestController// @Controller + @ResponseBody
@RequestMapping("/api")
@CrossOrigin(value = "*")
//@CrossOrigin(value = {"http://localhost:4200","http://localhost:3000"})
public class EmployeeController 
{
	@Autowired
	private EmployeeService service;

	@GetMapping("/employees")
	public List<Employee> findAllEmployees() {
		return service.getAllEmployees();
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> registerEmployee(@RequestBody Employee employee) 
	{
		Employee employee2 = service.saveEmployee(employee);
		return ResponseEntity.ok(employee2); //200
	}
	
	@PutMapping("/employees")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee employee2 = service.saveEmployee(employee);
		return ResponseEntity.ok(employee2); //200
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long id) {
		Boolean employee = service.deleteEmployee(id);
		return ResponseEntity.ok(employee); //200
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = service.getEmployeeById(id);
		return ResponseEntity.ok(employee); //200
	}
}
