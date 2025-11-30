package com.cirifa_azul.adoption.services.impl;

import com.cirifa_azul.adoption.domain.dtos.LoginResponseDTO;
import com.cirifa_azul.adoption.domain.dtos.LoginRequestDTO;
import com.cirifa_azul.adoption.domain.dtos.RegisterRequestDTO;
import com.cirifa_azul.adoption.exceptions.UserAlreadyExistsException;
import com.cirifa_azul.adoption.services.AuthService;
import com.cirifa_azul.adoption.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;

    @Override
    public LoginResponseDTO login(LoginRequestDTO request) {
        return null;
    }

    @Transactional
    @Override
    public LoginResponseDTO register(RegisterRequestDTO request) {
        if(userService.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("The email already exists");
        }
        if(userService.existsByUsername(request.getUsername())) {
            throw new UserAlreadyExistsException("The username already exists");
        }


    }
}
