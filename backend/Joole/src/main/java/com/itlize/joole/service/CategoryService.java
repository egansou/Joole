package com.itlize.joole.service;

import org.springframework.http.ResponseEntity;

import com.itlize.joole.entity.Category;

public interface CategoryService {
	
	public ResponseEntity<?> createCategory(Category category);

	public ResponseEntity<?> getCategories();

	public ResponseEntity<?> getCategoryById(int id);
	
	public ResponseEntity<?> deleteCategory(int id);
	
}
