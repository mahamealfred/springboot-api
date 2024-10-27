package com.example.backendapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendapi.entity.Product;
import com.example.backendapi.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
	private ProductRepository productRepository;
	
    public List<Product> getAllProducts(){
		return productRepository.findAll();
    	
    }
    
    public Product addProduct(Product product) {
		return productRepository.save(product);
    	
    }
}
