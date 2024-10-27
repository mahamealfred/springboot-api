package com.example.backendapi.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfig {
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().ignoringRequestMatchers("/api/users/register","/api/products","/api/users/{id}")  // Disable CSRF for user registration endpoint
            .and()
            .authorizeRequests()
           // .requestMatchers("/api/users/register","/api/products").permitAll()  // Allow public access to registration endpoint
            //.anyRequest().authenticated();  // All other requests require authentication
            .anyRequest().permitAll();
        return http.build();
    }
    
    

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();  // Replace with bcrypt in production
    }
}