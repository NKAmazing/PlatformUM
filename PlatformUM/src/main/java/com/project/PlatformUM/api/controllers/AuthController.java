package com.project.PlatformUM.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.PlatformUM.api.auth.AuthResponse;
import com.project.PlatformUM.api.auth.LoginRequest;
import com.project.PlatformUM.api.auth.RegisterRequest;
import com.project.PlatformUM.api.services.AuthService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) // ResponseEntity represent an HTTP response, including headers, body, and status. Flexible to allow for different types and formats of body content.
    { 
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));

    }
}