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
    
    // Update
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }

    // Delete
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
