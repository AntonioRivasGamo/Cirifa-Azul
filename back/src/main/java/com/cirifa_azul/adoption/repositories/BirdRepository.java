package com.cirifa_azul.adoption.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cirifa_azul.adoption.domain.entities.Bird;

public interface BirdRepository extends JpaRepository<Bird, UUID>, JpaSpecificationExecutor<Bird>{

}
