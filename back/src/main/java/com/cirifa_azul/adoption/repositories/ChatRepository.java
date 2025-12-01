package com.cirifa_azul.adoption.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cirifa_azul.adoption.domain.entities.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, UUID>{

}
