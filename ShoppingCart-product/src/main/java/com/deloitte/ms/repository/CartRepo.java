package com.deloitte.ms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deloitte.ms.entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, String>{
	
	@Query(value="select * from cart where customername=:name",nativeQuery = true)
	public List<Cart> getCartItemsFromCustomerName(String name);
	
	@Query(value="select * from cart where cartid=:id",nativeQuery = true)
	public List<Cart> getCartItemsFromCartId(int id);
}
