package com.juanjojmnz.gestorgastos.service;

import com.juanjojmnz.gestorgastos.dto.AuthRequest;
import com.juanjojmnz.gestorgastos.dto.AuthResponse;
import com.juanjojmnz.gestorgastos.entity.Usuario;
import com.juanjojmnz.gestorgastos.repository.UsuarioRepository;
import com.juanjojmnz.gestorgastos.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public void register(AuthRequest request) {
        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("El email ya está registrado");
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(request.getEmail());
        usuario.setNombre("Usuario"); // opcional
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        usuarioRepository.save(usuario);
    }

    public AuthResponse login(AuthRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );

            String token = jwtUtil.generateToken(request.getEmail());
            return new AuthResponse(token);
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Credenciales inválidas");
        }
    }
}