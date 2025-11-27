package com.cirifa_azul.adoption.services.impl;

import com.cirifa_azul.adoption.domain.dtos.LoginRequestDTO;
import com.cirifa_azul.adoption.domain.dtos.LoginResponseDTO;
import com.cirifa_azul.adoption.domain.entities.User;
import com.cirifa_azul.adoption.exceptions.BadCredentialsException;
import com.cirifa_azul.adoption.mappers.UserMapper;
import com.cirifa_azul.adoption.services.AuthService;
import com.cirifa_azul.adoption.services.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    // Es posible que toda la autenticacion se pueda hacer en una cadena de la securityfilterchain, mirarlo estaria interesante
    // Otra opcion seria usar algo como Keycloack

    private UserService userService;
    private UserMapper userMapper;
    
	public AuthServiceImpl(UserService userService, UserMapper userMapper) {
		super();
		this.userService = userService;
		this.userMapper = userMapper;
	}

	@Override
	public LoginResponseDTO login(LoginRequestDTO request) {
		// TODO Auto-generated method stub
		return null;
	}

//    @Override
//    public LoginResponseDTO login(LoginRequestDTO request) {
//        User savedUser = userService.findByEmail(request.getEmail())
//                .orElseThrow(() -> new BadCredentialsException("Login failed"));
//        //cambiar a comparacion de bcrypt
//        if(!request.getPassword().equals(savedUser.getPassword())) {
//            throw new BadCredentialsException("Login failed");
//        }
//        return userMapper.toDto(savedUser);
//    }
}
