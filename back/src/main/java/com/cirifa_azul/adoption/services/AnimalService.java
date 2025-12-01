package com.cirifa_azul.adoption.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cirifa_azul.adoption.domain.entities.Animal;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.HairLength;
import com.cirifa_azul.adoption.domain.entities.enums.Size;
import com.cirifa_azul.adoption.domain.entities.enums.WaterType;

public interface AnimalService {

	Optional<Animal> findById(UUID id);
	Animal createAnimal(Animal animal);
	Boolean deleteAnimal(UUID id);
	Animal updateAnimal(Animal animal);
	public List<Animal> findAnimalsByFilter(Gender gender, Integer age, Boolean canFly, Boolean canSpeak, Diet diet,
			HairLength hairLength, Boolean isCastrated, Boolean isVaccinated, Size size, Double weight, WaterType waterType);
}
