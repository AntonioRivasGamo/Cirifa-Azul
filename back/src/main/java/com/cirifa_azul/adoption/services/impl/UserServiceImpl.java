package com.cirifa_azul.adoption.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cirifa_azul.adoption.domain.entities.User;
import com.cirifa_azul.adoption.repositories.UserRepository;
import com.cirifa_azul.adoption.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
