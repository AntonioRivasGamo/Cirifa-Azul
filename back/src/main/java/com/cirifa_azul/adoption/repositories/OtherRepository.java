package com.cirifa_azul.adoption.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cirifa_azul.adoption.domain.entities.Other;

public interface OtherRepository extends JpaRepository<Other, UUID>, JpaSpecificationExecutor<Other>{

}
