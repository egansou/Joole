package com.itlize.joole.controller;

import org.springframework.beans.factory.annotation.Autowired;   
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itlize.joole.entity.Representative;
import com.itlize.joole.service.RepresentativeService;

@RestController
@RequestMapping("/representative")
public class RepresentativeController {
	

	@Autowired
	private RepresentativeService repService;

	@PostMapping("/")
	public ResponseEntity<?> createRepresentative (@RequestBody Representative rep) {
		return repService.createRepresentative(rep);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> listRepresentatives() {
		return repService.getRepresentatives();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getRepresentative(@PathVariable("id") int id) {
		return repService.getRepresentativeById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRepresentative(@PathVariable("id") int id) {
		return repService.deleteRepresentative(id);
		
	}
}
