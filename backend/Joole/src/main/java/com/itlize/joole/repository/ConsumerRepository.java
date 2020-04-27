package com.itlize.joole.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itlize.joole.entity.Consumer;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {
	
	
	Optional<Consumer> findByConsumerUsername(String username);
	Optional<Consumer> findByConsumerEmail(String email);
	

}