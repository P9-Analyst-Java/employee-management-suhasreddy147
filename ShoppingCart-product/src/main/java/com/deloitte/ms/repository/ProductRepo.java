package com.deloitte.ms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deloitte.ms.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, String>{
	
	@Query(value="select * from product",nativeQuery=true)
	public List<Product> getAllProducts();
	
	@Query(value="select * from product where productname=:name",nativeQuery=true)
	public List<Product> getProductsFromProductName(String name);
	
	@Query(value="select * from product where productid=:id",nativeQuery=true)
	public Product getProductsFromProductId(int id);
	
	@Query(value="update product set stocks=:stock where productid=:id",nativeQuery = true)
	public Product updateProductStockFromProductId(int id,int stock);
}
