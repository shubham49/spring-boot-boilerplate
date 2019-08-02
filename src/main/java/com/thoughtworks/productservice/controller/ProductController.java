package com.thoughtworks.productservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.productservice.model.Product;
import com.thoughtworks.productservice.service.ProductService;

@RestController
public class ProductController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductService productService;

	@GetMapping("/product")
	public List<Product> getProducts() {
		return productService.getProducts();
	}

	@PostMapping("/product")
	public Product saveProduct(@RequestBody Product product) {
		LOGGER.debug("product args:" + product);
		return productService.saveProduct(product);
	}
}
