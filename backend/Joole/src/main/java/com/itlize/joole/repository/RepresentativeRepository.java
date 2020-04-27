package com.itlize.joole.repository;

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.stereotype.Repository;

import com.itlize.joole.entity.Representative;

@Repository
public interface RepresentativeRepository extends JpaRepository<Representative, Integer> {
	

}