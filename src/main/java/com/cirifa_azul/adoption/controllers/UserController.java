package com.cirifa_azul.adoption.controllers;

import com.cirifa_azul.adoption.domain.dtos.LoginRequestDTO;
import com.cirifa_azul.adoption.domain.dtos.LoginResponseDTO;
import com.cirifa_azul.adoption.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Users API", description = "API to manage users")
public class UserController {
    //Esta es una de las cosas que mas molan de lombok con spring, inyeccion de dependencias sin constructores
    //private final AuthService authService;

    @PostMapping("/login")
    @Operation(summary = "Login for users")
    public ResponseEntity<LoginResponseDTO> loginUser(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
        LoginResponseDTO response = authService.login(loginRequestDTO);
        return ResponseEntity.ok(response);
    }
}
