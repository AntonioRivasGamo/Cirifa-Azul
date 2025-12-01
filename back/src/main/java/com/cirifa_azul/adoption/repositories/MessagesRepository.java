package com.cirifa_azul.adoption.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cirifa_azul.adoption.domain.entities.Messages;

public interface MessagesRepository extends JpaRepository<Messages, UUID>{

}
