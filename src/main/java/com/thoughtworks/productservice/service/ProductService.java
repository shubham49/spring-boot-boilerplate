package com.thoughtworks.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtworks.productservice.dao.ProductRepository;
import com.thoughtworks.productservice.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
}
