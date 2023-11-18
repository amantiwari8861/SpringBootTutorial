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
import com.bank.entity.Manager;
import com.bank.service.ManagerService;


@RestController// @Controller + @ResponseBody
@RequestMapping("/api")
@CrossOrigin(value = "*")
//@CrossOrigin(value = {"http://localhost:4200","http://localhost:3000"})
public class ManagerController {
	@Autowired
	private ManagerService service;

	@GetMapping("/managers")
	public List<Manager> findAllManagers() {
		return service.getAllManagers();
	}
	
	@PostMapping("/managers")
	public ResponseEntity<Manager> registerManager(@RequestBody Manager manager) 
	{
		Manager manager2 = service.saveManager(manager);
		return ResponseEntity.ok(manager2); //200
	}
	
	@PutMapping("/managers")
	public ResponseEntity<Manager> updateManager(@RequestBody Manager manager) {
		Manager manager2 = service.saveManager(manager);
		return ResponseEntity.ok(manager2); //200
	}
	
	@DeleteMapping("/managers/{id}")
	public ResponseEntity<Boolean> deleteManager(@PathVariable Long id) {
		Boolean manager = service.deleteManager(id);
		return ResponseEntity.ok(manager); //200
	}
	
	@GetMapping("/managers/{id}")
	public ResponseEntity<Manager> getManagerById(@PathVariable Long id) {
		Manager manager = service.getManagerById(id);
		return ResponseEntity.ok(manager); //200
	}
}
