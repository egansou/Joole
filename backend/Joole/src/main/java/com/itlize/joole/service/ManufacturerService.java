package com.itlize.joole.service;

import org.springframework.http.ResponseEntity; 

import com.itlize.joole.entity.Manufacturer;

public interface ManufacturerService {
	
	public ResponseEntity<?> createManufacturer(Manufacturer manuf);

	public ResponseEntity<?> getManufacturers();

	public ResponseEntity<?> getManufacturerById(int id);
	
	public ResponseEntity<?> deleteManufacturer(int id);
	
}
