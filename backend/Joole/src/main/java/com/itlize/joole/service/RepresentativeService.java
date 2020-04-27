package com.itlize.joole.service;

import org.springframework.http.ResponseEntity;

import com.itlize.joole.entity.Representative;

public interface RepresentativeService {
	
	public ResponseEntity<?> createRepresentative(Representative rep);

	public ResponseEntity<?> getRepresentatives();

	public ResponseEntity<?> getRepresentativeById(int id);
	
	public ResponseEntity<?> deleteRepresentative(int id);
	
}
