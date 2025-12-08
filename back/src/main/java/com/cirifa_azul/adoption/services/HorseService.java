package com.cirifa_azul.adoption.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cirifa_azul.adoption.domain.dtos.HorseDTO;
import com.cirifa_azul.adoption.domain.entities.Bird;
import com.cirifa_azul.adoption.domain.entities.Horse;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;

public interface HorseService {

	List<HorseDTO> findAll();
	Optional<HorseDTO> findById(UUID id);
	HorseDTO create(HorseDTO horseDTO);
	Optional<HorseDTO> update(HorseDTO horseDTO);
	Boolean delete(UUID id);
	List<HorseDTO> filterList(String name,
			Integer age,
			Gender gender,
			String breed,
			Boolean isVaccinated,
			Boolean isCastrated);
}
