package com.cirifa_azul.adoption.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cirifa_azul.adoption.domain.entities.Bird;
import com.cirifa_azul.adoption.domain.entities.Horse;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;

public interface HorseService {

	List<Horse> findAll();
	Optional<Horse> findById(UUID id);
	Horse create(Horse horse);
	Optional<Horse> update(Horse horse);
	Boolean delete(UUID id);
	List<Horse> filterList(String name,
			Integer age,
			Gender gender,
			String breed,
			Boolean isVaccinated,
			Boolean isCastrated);
}
