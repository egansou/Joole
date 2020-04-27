package com.itlize.joole.controller;

import java.util.Map;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itlize.joole.entity.Fan;
import com.itlize.joole.model.IdsObject;
import com.itlize.joole.service.FanService;

@RestController
@RequestMapping("/product")
public class ProductController {
	

	@Autowired
	private FanService fanService;

	@PostMapping("/")
	public ResponseEntity<?> createProduct (@RequestBody Fan fan) {
		return fanService.createFan(fan);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> listProducts() {
		return fanService.getFans();
	}
	
	@PostMapping("/compare")
	public ResponseEntity<?> listProductsIds(@RequestBody IdsObject idsString) {
		
		int [] ids = idsString.getIds();
		
		return fanService.getFansIds(ids);
	}
	
	@GetMapping("/filter")
	public ResponseEntity<?> listProductsFilter(@RequestParam Map<String, String> params) {
		
//		for (Map.Entry<String,String> entry : params.entrySet())  
//            System.out.println("Key = " + entry.getKey() + 
//                             ", Value = " + entry.getValue()); 

		return fanService.getFansFilter(params);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProduct(@PathVariable("id") int id) {
		return fanService.getFanById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") int id) {
		return fanService.deleteFan(id);
	}
}
