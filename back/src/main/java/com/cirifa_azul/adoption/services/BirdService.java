package com.cirifa_azul.adoption.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cirifa_azul.adoption.domain.entities.Bird;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;

public interface BirdService {

	List<Bird> findAll();
	Optional<Bird> findById(UUID id);
	Bird create(Bird bird);
	Optional<Bird> update(Bird bird);
	Boolean delete(UUID id);
	List<Bird> filterList(String name,
			Integer age,
			Gender gender,
			String breed,
			Diet diet,
			Boolean canSpeak,
			Boolean canFly);
}
