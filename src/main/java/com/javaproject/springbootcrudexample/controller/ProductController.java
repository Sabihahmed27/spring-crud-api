package com.javaproject.springbootcrudexample.controller;

import com.javaproject.springbootcrudexample.entity.Product;
import com.javaproject.springbootcrudexample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
         return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return service.getProducts();
    }

    @GetMapping("/product/{productId}")
    public Product findProductById(@PathVariable int productId){
        return service.getProductById(productId);
    }

    @GetMapping("/product/{productName}")
    public Product findProductByName(@PathVariable String productName){
        return service.getProductByName(productName);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(int productId){
        return service.deleteProduct(productId);
    }
}


