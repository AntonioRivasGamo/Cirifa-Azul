package com.cirifa_azul.adoption.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cirifa_azul.adoption.domain.entities.Bird;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.repositories.BirdRepository;
import com.cirifa_azul.adoption.repositories.specifications.BirdSpecification;
import com.cirifa_azul.adoption.services.BirdService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BirdServiceImpl implements BirdService{
	
	private final BirdRepository birdRepository;

	@Override
	public List<Bird> findAll() {
		return birdRepository.findAll();
	}

	@Override
	public Optional<Bird> findById(UUID id) {
		return birdRepository.findById(id);
	}

	@Override
	public Bird create(Bird bird) {
		return birdRepository.save(bird);
	}

	@Override
	public Optional<Bird> update(Bird bird) {
		return birdRepository.findById(bird.getId()).map(b -> birdRepository.save(bird));
	}

	@Override
	public Boolean delete(UUID id) {
		if(birdRepository.existsById(id)) {
			birdRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Bird> filterList(String name, Integer age, Gender gender, String breed, Diet diet, Boolean canSpeak,
			Boolean canFly) {
		return birdRepository.findAll(BirdSpecification.filterBird(name, age, gender, breed, diet, canSpeak, canFly));
	}

}
