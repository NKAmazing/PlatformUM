package com.project.PlatformUM.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.project.PlatformUM.api.jwt.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter JwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http
            .csrf(csrf ->
                csrf
                .disable())
            .authorizeHttpRequests(authRequest -> 
              authRequest
                //! */ To permite all request in swagger add "/api/v1/**"
                .requestMatchers("/auth/**", "/doc/swagger-ui/**", "/v3/api-docs/**", "/api/v1/**").permitAll()
                .requestMatchers("/token/**").permitAll()
                .anyRequest().authenticated()
                )
            .sessionManagement(sessionManager ->
                sessionManager
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authProvider)
            .addFilterBefore(JwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .build();

    }

}
