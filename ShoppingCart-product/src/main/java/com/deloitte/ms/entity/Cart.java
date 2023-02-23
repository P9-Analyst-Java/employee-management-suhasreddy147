package com.deloitte.ms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="cart")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cartid")
	private int cartid;
	@Column(name="status")
	private String status;
	@Column(name="quantity")
	private int quantity;
	@Column(name="customername")
	private String customername;
	@Column(name="productcategory")
	private String productcategory;
	@Column(name="productname")
	private String productname;
	@Column(name="productprice")
	private double productprice;
}
