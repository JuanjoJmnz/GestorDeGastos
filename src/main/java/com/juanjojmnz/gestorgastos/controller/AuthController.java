package com.juanjojmnz.gestorgastos.controller;

import com.juanjojmnz.gestorgastos.dto.AuthRequest;
import com.juanjojmnz.gestorgastos.dto.AuthResponse;
import com.juanjojmnz.gestorgastos.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest request) {
        authService.register(request);
        return "Usuario registrado correctamente";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return authService.login(request);
    }
}