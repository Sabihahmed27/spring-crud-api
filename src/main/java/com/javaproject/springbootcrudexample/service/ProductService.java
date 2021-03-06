package com.javaproject.springbootcrudexample.service;

import com.javaproject.springbootcrudexample.entity.Product;
import com.javaproject.springbootcrudexample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products);
    }


    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int productId){
        return productRepository.findById(productId).orElse(null);
    }

    public Product getProductByName(String productName){
        return productRepository.findByName(productName);
    }

    public String deleteProduct(int productId){
        productRepository.deleteById(productId);
        return String.format("product removed %s", productId);
    }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }

}
