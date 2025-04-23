package com.example.safewell.service;

import com.example.safewell.dto.LoginRequest;
import com.example.safewell.dto.SignupRequest;
import com.example.safewell.model.User;
import com.example.safewell.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String signup(SignupRequest request) {
        if (userRepo.findByEmail(request.getEmail()).isPresent()) {
            return "Email already registered!";
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepo.save(user);
        return "User registered successfully!";
    }

    public String login(LoginRequest request) {
        return userRepo.findByEmail(request.getEmail())
                .filter(user -> passwordEncoder.matches(request.getPassword(), user.getPassword()))
                .map(user -> "Login successful!")
                .orElse("Invalid email or password");
    }
}

