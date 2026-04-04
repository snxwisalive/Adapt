package com.diploma.adapt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diploma.adapt.dto.AuthResponseDTO;
import com.diploma.adapt.dto.UserLoginDTO;
import com.diploma.adapt.dto.UserRegistrationDTO;
import com.diploma.adapt.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public AuthResponseDTO registerUser(@Valid @RequestBody UserRegistrationDTO dto) {
        return authService.registerUser(dto);
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@Valid @RequestBody UserLoginDTO dto) {
        return authService.login(dto);
    }
}