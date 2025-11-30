package com.cirifa_azul.adoption.services;

import com.cirifa_azul.adoption.domain.dtos.AuthResponseDTO;
import com.cirifa_azul.adoption.domain.dtos.LoginRequestDTO;
import com.cirifa_azul.adoption.domain.dtos.RefreshTokenRequestDTO;
import com.cirifa_azul.adoption.domain.dtos.RegisterRequestDTO;

public interface AuthService {
    AuthResponseDTO login(LoginRequestDTO request);
    AuthResponseDTO register(RegisterRequestDTO request);
    AuthResponseDTO refreshToken(RefreshTokenRequestDTO request);
}
