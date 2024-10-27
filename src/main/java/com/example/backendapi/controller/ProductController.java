package com.example.backendapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendapi.dto.ApiResponse;
import com.example.backendapi.entity.Product;
import com.example.backendapi.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
    private ProductService productService;
	// Create
    @PostMapping
    public ResponseEntity<ApiResponse<Product>> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.addProduct(product);
        ApiResponse<Product> response = new ApiResponse<>(200, "Success", createdProduct);
        return ResponseEntity.ok(response);
    }

    // Read
    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        ApiResponse<List<Product>> response = new ApiResponse<>(200, "Success", products);
        return ResponseEntity.ok(response);
    }
    
 // Update
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        ApiResponse<Product> response = new ApiResponse<>(200, "Success", updatedProduct);
        return ResponseEntity.ok(response);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        ApiResponse<String> response = new ApiResponse<>(200, "Success", "Product deleted successfully!");
        return ResponseEntity.ok(response);
    }
}
