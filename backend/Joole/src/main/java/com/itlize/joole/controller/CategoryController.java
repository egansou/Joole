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

import com.itlize.joole.entity.Category;
import com.itlize.joole.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/")
	public ResponseEntity<?> createConsumer (@RequestBody Category category) {
		return categoryService.createCategory(category);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> listCategories() {
		return categoryService.getCategories();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCategory(@PathVariable("id") int id) {
		return categoryService.getCategoryById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable("id") int id) {
		return categoryService.deleteCategory(id);
		
	}
}
