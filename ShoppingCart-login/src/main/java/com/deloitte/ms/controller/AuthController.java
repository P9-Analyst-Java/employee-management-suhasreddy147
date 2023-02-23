package com.deloitte.ms.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deloitte.ms.entity.Cart;

@RestController
public class AuthController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/getproductdetails")
	public List<Object> getAllProductDetails(){
		Object response=restTemplate.getForObject("http://localhost:3003/product/getAll", Object.class);	
		return Arrays.asList(response);
	}
	
	@PostMapping("/addtocart/{username}/{id}")
	public Object addToCart(@RequestBody Cart cart,@PathVariable("username")String username, @PathVariable("id") int id) {
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Cart> request=new HttpEntity<Cart>(cart,headers);
		Object object=restTemplate.exchange("http://localhost:3003/cart/add/{username}/{id}", HttpMethod.POST, request, new ParameterizedTypeReference<String>() {
				}, username,id).getBody();
		return object;
	}
	
	@GetMapping("/getcartdetails/{username}")
	public List<Object> getCartDetailsByUsername(@PathVariable String username){
		Object response=restTemplate.getForObject("http://localhost:3003/cart/getbyusername/"+username, Object.class);
		return Arrays.asList(response);
	}
}
