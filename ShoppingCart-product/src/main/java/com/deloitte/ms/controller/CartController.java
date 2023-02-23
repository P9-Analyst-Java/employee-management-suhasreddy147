package com.deloitte.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deloitte.ms.entity.Cart;
import com.deloitte.ms.entity.Product;
import com.deloitte.ms.repository.CartRepo;
import com.deloitte.ms.repository.ProductRepo;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartRepo cartRepo;
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Cart>> getCart(){
		return new ResponseEntity<List<Cart>>(cartRepo.findAll(),HttpStatus.OK);
		
	}
	
	@GetMapping(value="/getbyid/{id}")
	public ResponseEntity<List<Cart>> getCartById(@PathVariable("id")int id){
		return new ResponseEntity<List<Cart>>(cartRepo.getCartItemsFromCartId(id),HttpStatus.OK);
	}
	
	@GetMapping("/getbyusername/{username}")
	public ResponseEntity<List<Cart>> getCartByUsername(@PathVariable("username")String username){
		return new ResponseEntity<List<Cart>>(cartRepo.getCartItemsFromCustomerName(username),HttpStatus.OK);
	}
	
	@PostMapping("/add/{username}/{id}")
	public ResponseEntity<Cart> addToCart(@RequestBody Cart cart, @PathVariable("username")String username,@PathVariable("id")int id){
		Product product = productRepo.getProductsFromProductId(id);
		Cart cart1 = new Cart(cart.getCartid(),"Shopping",cart.getQuantity(),username,product.getProductcategory(),product.getProductname(),product.getProductprice());
		return new ResponseEntity<Cart>(cartRepo.save(cart1),HttpStatus.OK);
	}
}
