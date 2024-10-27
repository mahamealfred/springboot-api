package com.example.backendapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendapi.dto.ApiResponse;
import com.example.backendapi.entity.Product;
import com.example.backendapi.entity.User;
import com.example.backendapi.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
	private UserService userService;
    @PostMapping("/register")
    private ResponseEntity<?>  registerUser(@RequestBody User user){
    	userService.registerUser(user);
    	 ApiResponse<String> response = new ApiResponse<>(200, "Success", "User registered successfully!");
        return ResponseEntity.ok(response);
    	
    }
    
//    @GetMapping
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        ApiResponse<List<User>> response = new ApiResponse<>(200, "Success", users);
        return ResponseEntity.ok(response);
    }
	
}
