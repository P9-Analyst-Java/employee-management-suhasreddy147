package com.deloitte.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShoppingCartRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartRegisterApplication.class, args);
	}

}
