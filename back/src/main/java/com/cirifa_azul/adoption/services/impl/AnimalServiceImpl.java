package com.cirifa_azul.adoption.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.cirifa_azul.adoption.domain.entities.Animal;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.HairLength;
import com.cirifa_azul.adoption.domain.entities.enums.Size;
import com.cirifa_azul.adoption.domain.entities.enums.WaterType;
import com.cirifa_azul.adoption.repositories.AnimalRepository;
import com.cirifa_azul.adoption.repositories.specifications.AnimalSpecifications;
import com.cirifa_azul.adoption.services.AnimalService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService{
	
	private final AnimalRepository animalRepository;

	@Override
	public List<Animal> findAnimalsByFilter(Gender gender, Integer age, Boolean canFly, Boolean canSpeak, Diet diet,
			HairLength hairLength, Boolean isCastrated, Boolean isVaccinated, Size size, Double weight,
			WaterType waterType) {
		Specification<Animal> spec = AnimalSpecifications.filter(gender, age, canFly, canSpeak, diet, 
				hairLength, isCastrated, isVaccinated, size, weight, waterType);
		return animalRepository.findAll(spec);
	}

	@Override
	public Optional<Animal> findById(UUID id) {
		return animalRepository.findById(id);
	}

	@Override
	public Animal createAnimal(Animal animal) {
		return animalRepository.save(animal);
	}

	@Override
	public Boolean deleteAnimal(UUID id) {
		if(animalRepository.existsById(id)) {
			animalRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Animal updateAnimal(Animal animal) {
		return animalRepository.save(animal);
	}

	

}
