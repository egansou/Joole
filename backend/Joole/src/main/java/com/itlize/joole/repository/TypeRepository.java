package com.itlize.joole.repository;

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.stereotype.Repository;

import com.itlize.joole.entity.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
	

}