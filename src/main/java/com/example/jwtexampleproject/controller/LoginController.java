package com.example.jwtexampleproject.controller;

import com.example.jwtexampleproject.model.dto.LoginRequestDto;
import com.example.jwtexampleproject.model.request.LoginRequest;
import com.example.jwtexampleproject.model.response.LoginResponse;
import com.example.jwtexampleproject.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
@RequiredArgsConstructor
public class LoginController {
    private final AuthService service;

    @PostMapping
    public LoginResponse login(@RequestBody LoginRequest request) {
        service.authenticate(request);
        return service.authenticate(request);
    }
}
