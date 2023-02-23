package com.deloitte.ms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {
	
	@Id
	@Column(name="productid")
	private int productid;
	@Column(name="productname")
	private String productname;
	@Column(name="productcategory")
	private String productcategory;
	@Column(name="productprice")
	private double productprice;
	@Column(name="stocks")
	private int stocks;
}
