package com.thoughtworks.productservice.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.thoughtworks.productservice.dao.ProductRepository;
import com.thoughtworks.productservice.model.Product;
import com.thoughtworks.productservice.service.ProductService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductServiceTest {

	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductService productService;

	@Test
	public void testGetProducts() {
		List<Product> prods = new ArrayList<Product>();
		prods.add(new Product(1l, "productone"));
		prods.add(new Product(2l, "producttwo"));

		when(productRepository.findAll()).thenReturn(prods);

		Assert.assertEquals(2, productService.getProducts().size());
	}

	@Test
	public void testSaveProduct() {
		Product p1 = new Product(1l, "productone");
		Product p2 = new Product(null, "productone");

		when(productRepository.save(Mockito.any())).thenReturn(p1);

		Assert.assertNotNull(productService.saveProduct(p2).getId());
	}
}
