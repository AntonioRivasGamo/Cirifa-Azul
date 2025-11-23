package com.cirifa_azul.adoption.services;

import com.cirifa_azul.adoption.domain.entities.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);
}
