package com.project.PlatformUM.api.services;

import com.project.PlatformUM.api.auth.AuthResponse;
import com.project.PlatformUM.api.auth.TokenResponse;
import com.project.PlatformUM.api.auth.LoginRequest;
import com.project.PlatformUM.api.auth.RegisterRequest;
import com.project.PlatformUM.api.models.Role;
import com.project.PlatformUM.api.models.User;
import com.project.PlatformUM.api.repositories.IUserRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final IUserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
            .email(request.getEmail())
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .telephone(request.getTelephone())
            .role(Role.USER)
            .build();

        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
        }

    public TokenResponse checkToken(AuthResponse request) {
        boolean isTokenValid = !jwtService.isTokenExpired(request.getToken());

        return TokenResponse.builder()
            .isTokenValid(isTokenValid)
            .build();
    }
}
