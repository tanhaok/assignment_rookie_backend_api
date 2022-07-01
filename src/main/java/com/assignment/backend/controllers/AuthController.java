package com.assignment.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.backend.dto.request.RegisterRequestDto;
import com.assignment.backend.dto.request.SignInRequestDto;
import com.assignment.backend.services.AuthService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * Sign In function
     * 
     * @param dto include two value: {@value username} and {@value password}
     * @return a token
     */
    @PostMapping("/signin")
    public String signIn(@RequestBody SignInRequestDto dto) {
        return this.authService.signIn(dto);
    }

    /**
     * Register new user with default role: USER
     * 
     * @param dto data to register
     * @return a token
     */
    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequestDto dto) {
        return this.authService.registerUser(dto);
    }
}
