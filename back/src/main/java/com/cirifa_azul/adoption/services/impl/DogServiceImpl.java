package com.cirifa_azul.adoption.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cirifa_azul.adoption.domain.entities.Dog;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.HairLength;
import com.cirifa_azul.adoption.domain.entities.enums.Size;
import com.cirifa_azul.adoption.repositories.DogRepository;
import com.cirifa_azul.adoption.repositories.specifications.DogSpecification;
import com.cirifa_azul.adoption.services.DogService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DogServiceImpl implements DogService{

	private final DogRepository dogRepository;
	
	@Override
	public List<Dog> findAll() {
		return dogRepository.findAll();
	}

	@Override
	public Optional<Dog> findById(UUID id) {
		return dogRepository.findById(id);
	}

	@Override
	public Dog create(Dog dog) {
		return dogRepository.save(dog);
	}

	@Override
	public Optional<Dog> update(Dog dog) {
		return dogRepository.findById(dog.getId()).map(d -> dogRepository.save(dog));
	}

	@Override
	public Boolean delete(UUID id) {
		if(dogRepository.existsById(id)) {
			dogRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Dog> filterList(Integer age, String breed, Gender gender, HairLength hairLength, Boolean isCastrated,
			Boolean isVaccinated, String name, Size size) {
		return dogRepository.findAll(DogSpecification.filterDogs(age, breed, gender, hairLength, isCastrated, 
				isVaccinated, name, size));
	}

	
}
