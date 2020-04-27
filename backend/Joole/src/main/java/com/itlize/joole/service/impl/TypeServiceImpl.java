package com.itlize.joole.service.impl;

import java.util.List;    
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itlize.joole.entity.Type;
import com.itlize.joole.model.MessageResponse;
import com.itlize.joole.model.idResponse;
import com.itlize.joole.repository.TypeRepository;
import com.itlize.joole.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeRepository typeRepository;
	
	@Transactional
	public ResponseEntity<?> createType(Type type) {
		
		try {
			
			Type t = typeRepository.save(type);
			
			return new ResponseEntity<>( new idResponse(t.getTypeId()), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>( new MessageResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	public ResponseEntity<?> getTypes() {

		List<Type> types = typeRepository.findAll();
		return new ResponseEntity<>(types, HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<?> getTypeById(int id) {
		
		try {
			Optional<Type> type= typeRepository.findById(id);
			if (type.isPresent()) {
				return new ResponseEntity<>(type.get(), HttpStatus.OK);
			}
			
			return new ResponseEntity<>( new MessageResponse("Not found"), HttpStatus.NOT_FOUND);
		}
		catch ( Exception e) {
			return new ResponseEntity<>( new MessageResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Transactional
	public ResponseEntity<?> deleteType(int id) {
		
		Optional<Type> type = typeRepository.findById(id);
		if (type.isPresent()){
			typeRepository.delete(type.get());
			return new ResponseEntity<>(new MessageResponse("Succesfully deleted"), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new MessageResponse("Nothing to delete"), HttpStatus.NOT_FOUND);
		}
	}

}





