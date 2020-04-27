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

import com.itlize.joole.entity.Type;
import com.itlize.joole.service.TypeService;

@RestController
@RequestMapping("/type")
public class TypeController {

	@Autowired
	private TypeService typeService;

	@PostMapping("/")
	public ResponseEntity<?> createConsumer (@RequestBody Type type) {
		return typeService.createType(type);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> listCategories() {
		return typeService.getTypes();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCategory(@PathVariable("id") int id) {
		return typeService.getTypeById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable("id") int id) {
		return typeService.deleteType(id);
		
	}
}
