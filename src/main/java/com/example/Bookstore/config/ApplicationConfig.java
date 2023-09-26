package com.example.Bookstore.config;

import com.example.Bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@RequiredArgsConstructor

public class ApplicationConfig {

    private final UserRepository repository;

    public UserDetailsService userDetailsService() {
        return username -> repository.findUserByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
