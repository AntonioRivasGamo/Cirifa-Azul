package com.cirifa_azul.adoption.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cirifa_azul.adoption.domain.entities.Dog;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.HairLength;
import com.cirifa_azul.adoption.domain.entities.enums.Size;

public interface DogService {

	List<Dog> findAll();
	Optional<Dog> findById(UUID id);
	Dog create(Dog dog);
	Optional<Dog> update(Dog dog);
	Boolean delete(UUID id);
	List<Dog> filterDogList(Integer age,
			String breed,
			Gender gender,
			HairLength hairLength,
			Boolean isCastrated,
			Boolean isVaccinated,
			String name,
			Size size,
			Double weight);
}
