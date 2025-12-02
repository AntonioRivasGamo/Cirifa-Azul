package com.cirifa_azul.adoption.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cirifa_azul.adoption.domain.entities.Cat;
import com.cirifa_azul.adoption.domain.entities.Dog;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.HairLength;
import com.cirifa_azul.adoption.domain.entities.enums.Size;

public interface CatService {

	List<Cat> findAll();
	Optional<Cat> findById(UUID id);
	Cat create(Cat cat);
	Optional<Cat> update(Cat cat);
	Boolean delete(UUID id);
	List<Cat> filterList(String name,
			Integer age,
			Gender gender,
			String breed,
			HairLength hairLength,
			Size size,
			Boolean isVaccinated,
			Boolean isCastrated);
}
