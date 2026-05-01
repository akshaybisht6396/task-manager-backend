package com.railways.demo.service;

import com.railways.demo.dto.SignupRequest;
import com.railways.demo.entity.Role;
import com.railways.demo.entity.User;
import com.railways.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Standard Constructor for Dependency Injection
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String registerUser(SignupRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Error: Email is already in use!");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        
        user.setRole(Role.valueOf(request.getRole().toUpperCase()));

        userRepository.save(user);
        return "User registered successfully!";
    }
}