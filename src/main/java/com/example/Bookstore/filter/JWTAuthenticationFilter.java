package com.example.Bookstore.filter;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
            //get authorization header
            final String authHeader = request.getHeader("Authorization");
            final String jwt;
            final String userEmail;
            //check if auth is null or does not start with bearer token
            if(authHeader == null || !authHeader.startsWith("Bearer ")) {
                //continue filter
                filterChain.doFilter(request, response);
                //we don't want to continue with the execution
                return;
            }
            //extract token from authorization header
            jwt = authHeader.substring(7);
            //extract user email from jwt token. For this we create a jwtService class and inject in JWTAuthenticationFilter
            userEmail= jwtService.extractUserName(jwt);


    }
}
