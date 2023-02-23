package com.deloitte.ms.controller;
 
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deloitte.ms.entity.LoginUser;
 
@RestController
@RequestMapping("/loginpage")
public class LoginUserController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    RestTemplate restTemplate;
    
    
    @PostMapping("/login")
    public ResponseEntity<HttpStatus> loginpage(@RequestBody LoginUser login) throws Exception{
        
        
        Authentication authObject = null;
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authObject);
        }catch(BadCredentialsException e) {
            throw new Exception("Invalid credentials");
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        
    }
    
//    @GetMapping("/login/getcartitems/")
//    public List<Object> getCartItems(){
//    	String url="http://ShoppingCart-product/cart/getbyusername/"+username;
//    	Object object=restTemplate.getForObject(url, Object.class);
//    	return Arrays.asList(object);
//    }
    
//    @PostMapping("/login/addtocart/{username}/{productid}")
//    public List<Object> addToCart(@PathVariable("username")String username,@PathVariable("productid")int id){
//    	String url="http://ShoppingCart-product/cart/add/"+username+"/"+id;
//    	Object object=restTemplate.getForObject(url, Object.class);
//    	return Arrays.asList(object);
//    }
}

