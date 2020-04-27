package com.itlize.joole.service.impl;

import java.util.List;  
import java.util.Optional;

import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itlize.joole.entity.Category;
import com.itlize.joole.model.MessageResponse;
import com.itlize.joole.model.idResponse;
import com.itlize.joole.repository.CategoryRepository;
import com.itlize.joole.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {


	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional
	public ResponseEntity<?> createCategory(Category category) {
		
		try {
			
			Category c = categoryRepository.save(category);
			
			return new ResponseEntity<>(new idResponse(c.getCategoryId()), HttpStatus.OK);
			
		} catch ( TransactionException e) {
			return new ResponseEntity<>( new MessageResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	public ResponseEntity<?> getCategories() {

		List<Category> categories = categoryRepository.findAll();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<?> getCategoryById(int id) {
		
		try {
			Optional<Category> category= categoryRepository.findById(id);
			if (category.isPresent()) {
				return new ResponseEntity<>(category.get(), HttpStatus.OK);
			}
			
			return new ResponseEntity<>( new MessageResponse("Not found"), HttpStatus.NOT_FOUND);
		}
		catch ( Exception e) {
			return new ResponseEntity<>( new MessageResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	public ResponseEntity<?> deleteCategory(int id) {
		
		Optional<Category> category = categoryRepository.findById(id);
		if (category.isPresent()){
			categoryRepository.delete(category.get());
			return new ResponseEntity<>(new MessageResponse("Succesfully deleted"), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new MessageResponse("Nothing to delete"), HttpStatus.NOT_FOUND);
		}
	}

}





