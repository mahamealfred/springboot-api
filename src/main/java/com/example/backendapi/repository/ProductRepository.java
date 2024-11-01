package com.example.backendapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backendapi.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContaining(String name);
}
