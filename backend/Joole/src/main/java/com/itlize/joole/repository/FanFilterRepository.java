package com.itlize.joole.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.itlize.joole.entity.Fan;

@Repository
public class FanFilterRepository {
	
	
	@Autowired
	private FanRepository fanRepository;
	
	public List<Fan> findByFilter(
			String yearMin, String yearMax, String airflowMin, String airflowMax, 
			String maxPowerMin, String maxPowerMax, String soundMin, String soundMax, 
			String sweepMin, String sweepMax, String heightMin, String heightMax,
			String firmMin, String firmMax, String globalMin, String globalMax,
			String useType, String application, String mountingLoc, String accessories,
			String manufacturer){
        return fanRepository.findAll(new Specification<Fan>() {
        	
			private static final long serialVersionUID = 1L;

			@Override
            public Predicate toPredicate(Root<Fan> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                double value = 0;
                
                if(yearMin != null) {
                	value = Double.parseDouble(yearMin);
                    predicates.add(cb.greaterThanOrEqualTo(root.get("modelYear"), value));
                }
                
                if(yearMax != null) {
                	value = Double.parseDouble(yearMax);
                    predicates.add(cb.lessThanOrEqualTo(root.get("modelYear"), value));
                }
                
                if(airflowMin != null) {
                	value = Double.parseDouble(airflowMin);
                    predicates.add(cb.greaterThanOrEqualTo(root.get("airflow"), value));
                }
                
                if(airflowMax != null) {
                	value = Double.parseDouble(airflowMax);
                    predicates.add(cb.lessThanOrEqualTo(root.get("airflow"), value));
                }
                
                if(maxPowerMin != null) {
                	value = Double.parseDouble(maxPowerMin);
                    predicates.add(cb.greaterThanOrEqualTo(root.get("powerMax"), value));
                }
                
                if(maxPowerMax != null) {
                	value = Double.parseDouble(maxPowerMax);
                    predicates.add(cb.lessThanOrEqualTo(root.get("powerMax"), value));
                }
                
                
                if(soundMin != null) {
                	value = Double.parseDouble(soundMin);
                    predicates.add(cb.greaterThanOrEqualTo(root.get("soundMaxSpeed"), value));
                }
                
                if(soundMax != null) {
                	value = Double.parseDouble(soundMax);
                    predicates.add(cb.lessThanOrEqualTo(root.get("soundMaxSpeed"), value));
                }
                
                if(sweepMin != null) {
                	value = Double.parseDouble(sweepMin);
                    predicates.add(cb.greaterThanOrEqualTo(root.get("fanDiameter"), value));
                }
                
                if(sweepMax != null) {
                	value = Double.parseDouble(sweepMax);
                    predicates.add(cb.lessThanOrEqualTo(root.get("fanDiameter"), value));
                }
                
                if(heightMin != null) {
                	value = Double.parseDouble(heightMin);
                    predicates.add(cb.greaterThanOrEqualTo(root.get("heightMax"), value));
                }
                
                if(heightMax != null) {
                	value = Double.parseDouble(heightMax);
                    predicates.add(cb.lessThanOrEqualTo(root.get("heightMax"), value));
                }
                
                if(firmMin != null) {
                	value = Double.parseDouble(firmMin);
                    predicates.add(cb.greaterThanOrEqualTo(root.get("firmSpec"), value));
                }
                
                if(firmMax != null) {
                	value = Double.parseDouble(firmMax);
                    predicates.add(cb.lessThanOrEqualTo(root.get("firmSpec"), value));
                }
                
                if(globalMin != null) {
                	value = Double.parseDouble(globalMin);
                    predicates.add(cb.greaterThanOrEqualTo(root.get("globalSpec"), value));
                }
                
                if(globalMax != null) {
                	value = Double.parseDouble(globalMax);
                    predicates.add(cb.lessThanOrEqualTo(root.get("globalSpec"), value));
                }
           
        		
                if(useType != null) {
                    predicates.add(cb.equal(root.get("useType"), useType));
                }
                
                if(application != null) {
                    predicates.add(cb.equal(root.get("application"), application));
                }
                
                if(mountingLoc != null) {
                    predicates.add(cb.equal(root.get("mountingLocation"), mountingLoc));
                }
                
                if(accessories != null) {
                    predicates.add(cb.equal(root.get("accessories"), accessories));
                }
                
                if(manufacturer != null) {
                    predicates.add(cb.equal(root.get("manufacturer").get("manufName"), manufacturer));
                }
                
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }

}
