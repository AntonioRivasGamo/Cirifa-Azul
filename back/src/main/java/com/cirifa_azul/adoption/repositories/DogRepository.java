package com.cirifa_azul.adoption.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cirifa_azul.adoption.domain.entities.Dog;

public interface DogRepository extends JpaRepository<Dog, UUID>, JpaSpecificationExecutor<Dog>{

}
