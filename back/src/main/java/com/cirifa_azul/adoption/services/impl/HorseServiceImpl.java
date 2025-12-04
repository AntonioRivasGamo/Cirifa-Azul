package com.cirifa_azul.adoption.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cirifa_azul.adoption.domain.entities.Horse;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.repositories.HorseRepository;
import com.cirifa_azul.adoption.repositories.specifications.HorseSpecification;
import com.cirifa_azul.adoption.services.HorseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HorseServiceImpl implements HorseService{

	private final HorseRepository horseRepository;
	
	@Override
	public List<Horse> findAll() {
		return horseRepository.findAll();
	}

	@Override
	public Optional<Horse> findById(UUID id) {
		return horseRepository.findById(id);
	}

	@Override
	public Horse create(Horse horse) {
		return horseRepository.save(horse);
	}

	@Override
	public Optional<Horse> update(Horse horse) {
		return horseRepository.findById(horse.getId()).map(h -> horseRepository.save(horse));
	}

	@Override
	public Boolean delete(UUID id) {
		if(horseRepository.existsById(id)) {
			horseRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Horse> filterList(String name, Integer age, Gender gender, String breed, Boolean isVaccinated,
			Boolean isCastrated) {
		return horseRepository.findAll(HorseSpecification.filterHorse(name, age, gender, breed, isVaccinated, isCastrated));
	}
	
	
}
