package com.thoughtworks.productservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thoughtworks.productservice.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
