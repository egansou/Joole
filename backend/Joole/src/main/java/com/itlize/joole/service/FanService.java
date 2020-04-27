package com.itlize.joole.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;  

import com.itlize.joole.entity.Fan;
 
public interface FanService {
	
	public ResponseEntity<?> createFan(Fan fan);

	public ResponseEntity<?> getFans();

	public ResponseEntity<?> getFanById(int id);
	
	public ResponseEntity<?> deleteFan(int id);

	public ResponseEntity<?> getFansIds(int[] ids);

	public ResponseEntity<?> getFansFilter(Map<String, String> params);
	
}
