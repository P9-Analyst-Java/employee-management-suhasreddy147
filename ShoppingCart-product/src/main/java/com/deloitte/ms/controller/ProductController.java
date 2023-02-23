package com.deloitte.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.ms.entity.Product;
import com.deloitte.ms.repository.ProductRepo;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductRepo productRepo;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Product>> getProduct(){
		return new ResponseEntity<List<Product>>(productRepo.findAll(),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(productRepo.save(product),HttpStatus.OK);
	}
	
	@PostMapping("/updatestock")
	public ResponseEntity<Product> updateStocks(@RequestBody Product product){
		return new ResponseEntity<Product>(productRepo.updateProductStockFromProductId(
				product.getProductid(), product.getStocks()),HttpStatus.OK);		
	}
}
