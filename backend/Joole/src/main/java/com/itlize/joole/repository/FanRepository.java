package com.itlize.joole.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itlize.joole.entity.Fan;

@Repository
public interface FanRepository extends JpaRepository<Fan, Integer>, JpaSpecificationExecutor<Fan>{
	
	
	@Query(value = "Select * FROM fan WHERE fan_id IN :ids", nativeQuery = true)
	List<Fan> findByIds(@Param("ids") int[] ids);
	
	//@Query(value = "Select * FROM fan WHERE airflow BETWEEN :val1 AND :val2 ", nativeQuery = true)
	//List<Fan> findByFilter(@Param("val1") int val1, @Param("val2") int val2);
	
}