package com.cirifa_azul.adoption.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cirifa_azul.adoption.domain.dtos.BirdDTO;
import com.cirifa_azul.adoption.domain.entities.Bird;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;

public interface BirdService {

	List<BirdDTO> findAll();
	Optional<BirdDTO> findById(UUID id);
	BirdDTO create(BirdDTO birdDTO);
	Optional<BirdDTO> update(BirdDTO birdDTO);
	Boolean delete(UUID id);
	List<BirdDTO> filterList(String name,
			Integer age,
			Gender gender,
			String breed,
			Diet diet,
			Boolean canSpeak,
			Boolean canFly);
}
