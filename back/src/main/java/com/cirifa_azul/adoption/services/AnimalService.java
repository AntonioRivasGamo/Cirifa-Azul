package com.cirifa_azul.adoption.services;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.cirifa_azul.adoption.domain.entities.Animal;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.HairLength;
import com.cirifa_azul.adoption.domain.entities.enums.Size;
import com.cirifa_azul.adoption.domain.entities.enums.WaterType;
import com.cirifa_azul.adoption.repositories.AnimalRepository;
import com.cirifa_azul.adoption.repositories.specifications.AnimalSpecifications;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AnimalService {
	
	private final AnimalRepository animalRepository;

	public List<Animal> findAnimalsByFilter(Gender gender, Integer age, Boolean canFly, Boolean canSpeak, Diet diet,
			HairLength hairLength, Boolean isCastrated, Boolean isVaccinated, Size size, Double weight, WaterType waterType){
		Specification<Animal> spec = AnimalSpecifications.filter(gender, age, canFly, canSpeak, diet, 
				hairLength, isCastrated, isVaccinated, size, weight, waterType);
		return animalRepository.findAll(spec);
	}
}
