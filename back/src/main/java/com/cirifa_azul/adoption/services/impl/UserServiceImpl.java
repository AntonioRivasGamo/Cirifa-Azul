package com.cirifa_azul.adoption.services.impl;

import com.cirifa_azul.adoption.domain.entities.User;
import com.cirifa_azul.adoption.repositories.UserRepository;
import com.cirifa_azul.adoption.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
