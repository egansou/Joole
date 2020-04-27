package com.itlize.joole.service.impl;

import java.util.List;     
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itlize.joole.entity.Manufacturer;
import com.itlize.joole.model.MessageResponse;
import com.itlize.joole.model.idResponse;
import com.itlize.joole.repository.ManufacturerRepository;
import com.itlize.joole.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	private ManufacturerRepository manufRepository;
	
	@Transactional
	public ResponseEntity<?> createManufacturer(Manufacturer manuf) {
		try {
			
			Manufacturer m = manufRepository.save(manuf);	
			return new ResponseEntity<>(new idResponse(m.getManufId()), HttpStatus.OK);
		
		} catch (Exception e) {
			return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	public ResponseEntity<?> getManufacturers() {

		List<Manufacturer> manufs = manufRepository.findAll();
		return new ResponseEntity<>(manufs, HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<?> getManufacturerById(int id) {
		
		try {
			Optional<Manufacturer> manuf = manufRepository.findById(id);
			if (manuf.isPresent()) {
				return new ResponseEntity<>(manuf.get(), HttpStatus.OK);
			}
			return new ResponseEntity<>( new MessageResponse("Not found"), HttpStatus.NOT_FOUND);
		}
		catch ( Exception e) {
			return new ResponseEntity<>( new MessageResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Transactional
	public ResponseEntity<?> deleteManufacturer(int id) {
		
		Optional<Manufacturer> manuf = manufRepository.findById(id);
		if (manuf.isPresent()){
			manufRepository.delete(manuf.get());
			return new ResponseEntity<>(new MessageResponse("Succesfully deleted"), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new MessageResponse("Nothing to delete"), HttpStatus.NOT_FOUND);
		}
	}

}





