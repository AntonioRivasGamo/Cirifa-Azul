package com.cirifa_azul.adoption.services;

import com.cirifa_azul.adoption.domain.dtos.LoginResponseDTO;
import com.cirifa_azul.adoption.domain.dtos.LoginRequestDTO;
import com.cirifa_azul.adoption.domain.dtos.RegisterRequestDTO;

public interface AuthService {
    LoginResponseDTO login(LoginRequestDTO request);
    LoginResponseDTO register(RegisterRequestDTO request);
}
