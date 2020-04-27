package com.itlize.joole.controller;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.itlize.joole.entity.Consumer;
import com.itlize.joole.service.ConsumerService;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

	@Autowired
	private ConsumerService consumerService;

	@PostMapping("/create")
	public ResponseEntity<?> createConsumer (@RequestBody Consumer consumer) {
		return consumerService.createConsumer(consumer);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Consumer consumer) {
		return consumerService.login(consumer);
	}
		
	@GetMapping("/")
	public ResponseEntity<?> listCustomers() {
		return consumerService.getConsumers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getConsumer(@PathVariable("id") int id) {
		return consumerService.getConsumerById(id);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") int id) {
		return consumerService.deleteConsumer(id);
		
	}
}
