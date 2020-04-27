package com.itlize.joole.service;

import org.springframework.http.ResponseEntity; 

import com.itlize.joole.entity.Type;

public interface TypeService {
	
	public ResponseEntity<?> createType(Type type);

	public ResponseEntity<?> getTypes();

	public ResponseEntity<?> getTypeById(int id);
	
	public ResponseEntity<?> deleteType(int id);
	
}
