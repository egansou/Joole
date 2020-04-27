package com.itlize.joole.service;

import org.springframework.http.ResponseEntity;
import com.itlize.joole.entity.Consumer;

public interface ConsumerService {

	public ResponseEntity<?> getConsumers();

	public ResponseEntity<?> createConsumer(Consumer consumer);
	
	public ResponseEntity<?> getConsumerById(int id);
	
	public ResponseEntity<?> login(Consumer consumer);
	
	public ResponseEntity<?> deleteConsumer(int id);
	
}
