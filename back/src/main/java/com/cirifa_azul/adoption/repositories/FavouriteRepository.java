package com.cirifa_azul.adoption.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cirifa_azul.adoption.domain.entities.Favourite;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, UUID>{

}
