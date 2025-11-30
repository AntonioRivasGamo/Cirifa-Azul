package com.cirifa_azul.adoption.services.impl;

import com.cirifa_azul.adoption.domain.dtos.AuthResponseDTO;
import com.cirifa_azul.adoption.domain.dtos.LoginRequestDTO;
import com.cirifa_azul.adoption.domain.dtos.RefreshTokenRequestDTO;
import com.cirifa_azul.adoption.domain.dtos.RegisterRequestDTO;
import com.cirifa_azul.adoption.domain.entities.User;
import com.cirifa_azul.adoption.domain.entities.enums.UserRole;
import com.cirifa_azul.adoption.exceptions.BadCredentialsException;
import com.cirifa_azul.adoption.exceptions.InvalidJwtException;
import com.cirifa_azul.adoption.exceptions.UserAlreadyExistsException;
import com.cirifa_azul.adoption.mappers.AuthMapper;
import com.cirifa_azul.adoption.security.jwt.JwtService;
import com.cirifa_azul.adoption.services.AuthService;
import com.cirifa_azul.adoption.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final AuthMapper authMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponseDTO login(LoginRequestDTO request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } catch (org.springframework.security.core.AuthenticationException e) {
            throw new BadCredentialsException("Invalid credentials");
        }

        User user = userService.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Invalid credentials"));

        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        AuthResponseDTO response = authMapper.toDto(user);
        return authMapper.setTokens(response, accessToken, refreshToken);
    }

    @Transactional
    @Override
    public AuthResponseDTO register(RegisterRequestDTO request) {
        if (userService.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("The email already exists");
        }
        if (userService.existsByUsername(request.getUsername())) {
            throw new UserAlreadyExistsException("The username already exists");
        }
        User newUser = authMapper.fromDto(request);
        newUser.setRole(UserRole.CLIENT);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        User savedUser = userService.createUser(newUser);

        String accessToken = jwtService.generateAccessToken(savedUser);
        String refreshToken = jwtService.generateRefreshToken(savedUser);

        AuthResponseDTO response = authMapper.toDto(savedUser);
        return authMapper.setTokens(response, accessToken, refreshToken);
    }

    @Override
    public AuthResponseDTO refreshToken(RefreshTokenRequestDTO request) {
        String refreshToken = request.getRefreshToken();
        String email = jwtService.extractUsername(refreshToken);

        if (email == null) {
            throw new InvalidJwtException("Invalid refresh token");
        }

        User user = userService.findByEmail(email)
                .orElseThrow(() -> new BadCredentialsException("User doesn't exist"));

        if (!jwtService.isRefreshTokenValid(refreshToken, user)) {
            throw new InvalidJwtException("Refresh token expired");
        }

        String newAccessToken = jwtService.generateAccessToken(user);

        AuthResponseDTO response = authMapper.toDto(user);
        return authMapper.setTokens(response, newAccessToken, refreshToken);
    }

}
