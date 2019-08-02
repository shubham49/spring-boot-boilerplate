package com.thoughtworks.productservice.controllers;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.thoughtworks.productservice.controller.ProductController;
import com.thoughtworks.productservice.dao.ProductRepository;
import com.thoughtworks.productservice.model.Product;
import com.thoughtworks.productservice.service.ProductService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductControllerTest {

	@Mock
	private ProductService productService;

	@InjectMocks
	private ProductController productController;

	@Autowired
	private ProductRepository prodRep;

	@Test
	@Sql(scripts = "/data/data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void testInitialData() {
		Assert.assertEquals(3, prodRep.findAll().size());
	}

	@Test
	public void testSaveProduct() {
		Product mockProduct = new Product(1l, "productone");
		Product productToSave = new Product(null, "productone");

		when(productService.saveProduct(Mockito.any())).thenReturn(mockProduct);

		Product prod = productController.saveProduct(productToSave);

		Assert.assertEquals("productone", prod.getProductName());
	}

	@Test
	public void testGetProducts() {
		List<Product> prods = new ArrayList<Product>();
		prods.add(new Product(1l, "productone"));
		prods.add(new Product(2l, "producttwo"));
		
		when(productService.getProducts()).thenReturn(prods);
		
		Assert.assertEquals(2, productController.getProducts().size());
	}
}
