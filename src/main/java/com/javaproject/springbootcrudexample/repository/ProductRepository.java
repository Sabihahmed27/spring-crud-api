package com.javaproject.springbootcrudexample.repository;

import com.javaproject.springbootcrudexample.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String productName);
}
