package com.thoughtworks.productservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	private String productName;

	public Product() {
		
	}
	
	public Product(Long id, String productName) {
		this.productName = productName;
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	@Override
	public String toString() {
		return id + "|" + productName;
	}
}
