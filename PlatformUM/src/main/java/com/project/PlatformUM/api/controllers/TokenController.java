package com.project.PlatformUM.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.PlatformUM.api.auth.AuthResponse;
import com.project.PlatformUM.api.auth.TokenResponse;
import com.project.PlatformUM.api.services.AuthService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/token")
@RequiredArgsConstructor
public class TokenController {

    private final AuthService authService;

    @PostMapping(value = "verify")
    public ResponseEntity<TokenResponse> tokenVerify(@RequestBody AuthResponse request)
    {
        return ResponseEntity.ok(authService.checkToken(request));
    }
}