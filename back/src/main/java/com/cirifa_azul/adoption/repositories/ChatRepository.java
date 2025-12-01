package com.cirifa_azul.adoption.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cirifa_azul.adoption.domain.entities.Chat;

public interface ChatRepository extends JpaRepository<Chat, UUID>{

}
