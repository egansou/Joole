package com.itlize.joole.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itlize.joole.entity.Fan;
import com.itlize.joole.model.MessageResponse;
import com.itlize.joole.model.idResponse;
import com.itlize.joole.repository.FanFilterRepository;
import com.itlize.joole.repository.FanRepository;
import com.itlize.joole.service.FanService;

@Service
public class FanServiceImpl implements FanService {


	@Autowired
	private FanRepository fanRepository;
	
	@Autowired
	private FanFilterRepository fanFilterRepository;
	
	@Transactional
	public ResponseEntity<?> createFan(Fan fan) {
		
		try {
			
			Fan f =  fanRepository.save(fan);
			
			return new ResponseEntity<>(new idResponse(f.getFanId()), HttpStatus.OK);
			
		} catch ( TransactionException e) {
			return new ResponseEntity<>( new MessageResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	public ResponseEntity<?> getFans() {
		
		List<Fan> fans = fanRepository.findAll();
		return new ResponseEntity<>(fans, HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<?> getFansIds(int[] ids) {
		
		List<Fan> fans = fanRepository.findByIds(ids);
		return new ResponseEntity<>(fans, HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<?> getFansFilter(Map<String, String> params) {
		
		String yearMin = params.get("yearMin");
		String yearMax = params.get("yearMax");
	
		String airflowMin = params.get("airflowMin");
		String airflowMax = params.get("airflowMax");
		
		String maxPowerMin = params.get("maxPowerMin");
		String maxPowerMax = params.get("maxPowerMax");
		
		String soundMin = params.get("soundMin");
		String soundMax = params.get("soundMax");
		
		String sweepMin = params.get("sweepMin");
		String sweepMax = params.get("sweepMax");
		
		String heightMin = params.get("heightMin");
		String heightMax = params.get("heightMax");
		
		String firmMin = params.get("firmMin");
		String firmMax = params.get("firmMax");
		
		String globalMin = params.get("globalMin");
		String globalMax = params.get("globalMax");
		
		String useType = params.get("useType");
		String application = params.get("application");
		String mountingLoc = params.get("mountingLoc");
		String accessories = params.get("accessories");
		String manufacturer = params.get("manufacturer");
          
		List<Fan> fans = fanFilterRepository.findByFilter(yearMin, yearMax, airflowMin, airflowMax, maxPowerMin, maxPowerMax,
				soundMin, soundMax, sweepMin, sweepMax, heightMin, heightMax, firmMin, firmMax, globalMin,
				globalMax, useType, application, mountingLoc, accessories, manufacturer);
		
		return new ResponseEntity<>(fans, HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<?> getFanById(int id) {
		
		try {
			Optional<Fan> fan= fanRepository.findById(id);
			if (fan.isPresent()) {
				return new ResponseEntity<>(fan.get(), HttpStatus.OK);
			}			
			return new ResponseEntity<>( new MessageResponse("Not found"), HttpStatus.NOT_FOUND);
		}
		catch ( Exception e) {
			return new ResponseEntity<>( new MessageResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	public ResponseEntity<?> deleteFan(int id) {
		
		Optional<Fan> fan = fanRepository.findById(id);
		if (fan.isPresent()){
			fanRepository.delete(fan.get());
			return new ResponseEntity<>(new MessageResponse("Succesfully deleted"), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new MessageResponse("Nothing to delete"), HttpStatus.NOT_FOUND);
		}
	}

}





