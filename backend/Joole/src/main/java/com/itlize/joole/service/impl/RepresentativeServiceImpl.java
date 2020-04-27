package com.itlize.joole.service.impl;

import java.util.List;   
import java.util.Optional;

import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itlize.joole.entity.Representative;
import com.itlize.joole.model.MessageResponse;
import com.itlize.joole.model.idResponse;
import com.itlize.joole.repository.RepresentativeRepository;
import com.itlize.joole.service.RepresentativeService;

@Service
public class RepresentativeServiceImpl implements RepresentativeService {


	@Autowired
	private RepresentativeRepository repRepository;
	
	@Transactional
	public ResponseEntity<?> createRepresentative(Representative rep) {
		
		try {
			
			Representative r = repRepository.save(rep);
			
			return new ResponseEntity<>(new idResponse(r.getRepId()), HttpStatus.OK);
			
		} catch ( TransactionException e) {
			return new ResponseEntity<>( new MessageResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	public ResponseEntity<?> getRepresentatives() {

		List<Representative> reps = repRepository.findAll();
		return new ResponseEntity<>(reps, HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<?> getRepresentativeById(int id) {
		
		try {
			Optional<Representative> rep= repRepository.findById(id);
			if (rep.isPresent()) {
				return new ResponseEntity<>(rep.get(), HttpStatus.OK);
			}
			
			return new ResponseEntity<>(new MessageResponse("Not found"), HttpStatus.NOT_FOUND);
		}
		catch ( Exception e) {
			return new ResponseEntity<>( new MessageResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	public ResponseEntity<?> deleteRepresentative(int id) {
		
		Optional<Representative> rep = repRepository.findById(id);
		if (rep.isPresent()){
			repRepository.delete(rep.get());
			return new ResponseEntity<>(new MessageResponse("Succesfully deleted"), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new MessageResponse("Nothing to delete"), HttpStatus.NOT_FOUND);
		}
	}

}





