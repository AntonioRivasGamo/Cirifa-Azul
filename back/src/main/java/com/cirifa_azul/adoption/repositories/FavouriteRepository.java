package com.cirifa_azul.adoption.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cirifa_azul.adoption.domain.entities.Favourite;

public interface FavouriteRepository extends JpaRepository<Favourite, UUID>{

}
