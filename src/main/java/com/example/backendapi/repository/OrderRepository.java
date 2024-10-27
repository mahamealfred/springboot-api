package com.example.backendapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backendapi.entity.Order;
import com.example.backendapi.entity.User;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
