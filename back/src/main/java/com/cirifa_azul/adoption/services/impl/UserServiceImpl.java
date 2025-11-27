package com.cirifa_azul.adoption.services.impl;

import com.cirifa_azul.adoption.domain.entities.User;
import com.cirifa_azul.adoption.repositories.UserRepository;
import com.cirifa_azul.adoption.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
