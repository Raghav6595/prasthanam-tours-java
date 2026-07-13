package com.prasthanam.tours.controller;

import com.prasthanam.tours.security.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Value("${admin.username}")
    private String adminUsername;

    @Value("${admin.password-hash}")
    private String adminPasswordHash;

    public AuthController(JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public record LoginRequest(String username, String password) {}
    public record LoginResponse(String token) {}
    public record ErrorResponse(String message) {}

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        if (request.username() == null || request.password() == null) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Username and password are required"));
        }

        boolean usernameMatches = adminUsername.equals(request.username());
        boolean passwordMatches = passwordEncoder.matches(request.password(), adminPasswordHash);

        if (!usernameMatches || !passwordMatches) {
            return ResponseEntity.status(401).body(new ErrorResponse("Invalid username or password"));
        }

        String token = jwtService.generateToken(request.username());
        return ResponseEntity.ok(new LoginResponse(token));
    }
}