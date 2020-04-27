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

import com.itlize.joole.entity.Manufacturer;
import com.itlize.joole.service.ManufacturerService;

@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController {
	

	@Autowired
	private ManufacturerService manufService;

	@PostMapping("/")
	public ResponseEntity<?> createManufacturer (@RequestBody Manufacturer manuf) {
		return manufService.createManufacturer(manuf);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> listManufacturers() {
		return manufService.getManufacturers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getManufacturer(@PathVariable("id") int id) {
		return manufService.getManufacturerById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteManufacturer(@PathVariable("id") int id) {
		return manufService.deleteManufacturer(id);
		
	}
}
