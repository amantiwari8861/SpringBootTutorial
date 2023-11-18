package com.training.voting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.voting.entity.GoVoters;
import com.training.voting.service.GoVotersService;

@RestController// @Controller + @ResponseBody
@RequestMapping("/api/voting")
public class GoVotersController {

	@Autowired
	private GoVotersService service;

	@GetMapping("/voters")
	public List<GoVoters> findAllVoters() {
		return service.getAllVoters();
	}
	
	@PostMapping("/voters")
	public ResponseEntity<GoVoters> registerVoter(@RequestBody GoVoters goVoters) {
		GoVoters voter = service.saveVoter(goVoters);
		return ResponseEntity.ok(voter); //200
	}
	
	@PutMapping("/voters")
	public ResponseEntity<GoVoters> updateVoter(@RequestBody GoVoters goVoters) {
		GoVoters voter = service.saveVoter(goVoters);
		return ResponseEntity.ok(voter); //200
	}
	
	@DeleteMapping("/voters/{id}")
	public ResponseEntity<Boolean> deleteVoter(@PathVariable Long id) {
		Boolean voter = service.deleteVoter(id);
		return ResponseEntity.ok(voter); //200
	}
	
	@GetMapping("/voters/{id}")
	public ResponseEntity<GoVoters> getVoterById(@PathVariable Long id) {
		GoVoters goVoters = service.getVoterById(id);
		return ResponseEntity.ok(goVoters); //200
	}
	@GetMapping("/voters/by-aadhar/{aadharNumber}")
	public ResponseEntity<GoVoters> getVoterByAadhar(@PathVariable Long aadharNumber) {
		GoVoters goVoters = service.getVoterByAadharNumber(aadharNumber);
		return ResponseEntity.ok(goVoters); //200
	}
	
}
