package com.example.backendapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendapi.entity.Product;
import com.example.backendapi.entity.User;
import com.example.backendapi.repository.UserRepository;

@Service
public class UserService {
    @Autowired
	private UserRepository userRepository;
    
    public  User registerUser(User user) {
    	return userRepository.save(user);
    }
    
    public Optional<User> findByUsername(String username){
		return userRepository.findByUsername(username);
    	
    }
    public List<User> getAllUsers(){
		return userRepository.findAll();
    	
    }
    
 // Update
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    // Delete
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
