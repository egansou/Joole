package com.itlize.joole.service.impl;

import java.util.List;   
import java.util.Optional;

import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.itlize.joole.entity.Consumer;
import com.itlize.joole.model.AuthenticationResponse;
import com.itlize.joole.model.MessageResponse;
import com.itlize.joole.repository.ConsumerRepository;
import com.itlize.joole.service.ConsumerService;
import com.itlize.joole.util.JwtUtil;

@Service
public class ConsumerServiceImpl implements ConsumerService {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private ConsumerRepository consumerRepository;
	
	@Transactional
	public ResponseEntity<?> createConsumer(Consumer consumer) {
		
		try {
		
			String plain_password = consumer.getConsumerPassword();
			consumer.setConsumerPassword(BCrypt.hashpw(plain_password, BCrypt.gensalt()));
			
			consumerRepository.save(consumer);
			
			final UserDetails userDetails = userDetailsService
					.loadUserByUsername(consumer.getConsumerUsername());

			final String jwt = jwtTokenUtil.generateToken(userDetails);			
			
			return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
			
		    } catch ( TransactionException e) {
				return new ResponseEntity<>( new MessageResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
			} 
	}
	
	@Transactional
	public ResponseEntity<?> login(Consumer consumer) {
		
		try {
			String email = consumer.getConsumerEmail();
			String username = consumer.getConsumerUsername();
			String password = consumer.getConsumerPassword();
			
			if (consumer.getConsumerEmail() != null ) {
				Optional <Consumer> c = consumerRepository.findByConsumerEmail(email);
				
				if( c.isPresent()) {
					username = c.get().getConsumerUsername();
				} else {
					return new ResponseEntity<>(new MessageResponse("The credentials are inaccurate"), 
						HttpStatus.FORBIDDEN);
				}
			}
			
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(username, password));
			
			final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

			final String jwt = jwtTokenUtil.generateToken(userDetails);

			return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
		}
		catch (BadCredentialsException e) {
			return new ResponseEntity<>(new MessageResponse("The credentials are inaccurate"), 
					HttpStatus.FORBIDDEN);
		}
		catch(Exception e) {
			return new ResponseEntity<>(new MessageResponse("The credentials are inaccurate"), 
					HttpStatus.FORBIDDEN);
		}
	
	}
	
	@Transactional
	public ResponseEntity<?> getConsumers() {

		List<Consumer> consumers = consumerRepository.findAll();
		return new ResponseEntity<>(consumers, HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<?> getConsumerById(int id) {
		
		try {
			Optional<Consumer> consumer= consumerRepository.findById(id);
			if (consumer.isPresent()) {
				return new ResponseEntity<>(consumer.get(), HttpStatus.OK);
			}
			
			return new ResponseEntity<>( new MessageResponse("Not found"), HttpStatus.NOT_FOUND);
		}
		catch ( Exception e) {
			return new ResponseEntity<>( new MessageResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@Transactional
	public ResponseEntity<?> deleteConsumer(int id) {
		
		Optional<Consumer> consumer = consumerRepository.findById(id);
		if (consumer.isPresent()){
			consumerRepository.delete(consumer.get());
			return new ResponseEntity<>(new MessageResponse("Succesfully deleted"), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new MessageResponse("Nothing to delete"), HttpStatus.NOT_FOUND);
		}
	}

}








