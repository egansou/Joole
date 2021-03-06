package com.itlize.joole.repository;

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.stereotype.Repository;

import com.itlize.joole.entity.Manufacturer;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
	
}