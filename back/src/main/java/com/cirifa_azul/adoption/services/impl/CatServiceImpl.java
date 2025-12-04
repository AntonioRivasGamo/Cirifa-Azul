package com.cirifa_azul.adoption.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cirifa_azul.adoption.domain.entities.Cat;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.HairLength;
import com.cirifa_azul.adoption.domain.entities.enums.Size;
import com.cirifa_azul.adoption.repositories.CatRepository;
import com.cirifa_azul.adoption.repositories.specifications.CatSpecification;
import com.cirifa_azul.adoption.services.CatService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CatServiceImpl implements CatService{

	private final CatRepository catRepository;
	
	@Override
	public List<Cat> findAll() {
		return catRepository.findAll();
	}

	@Override
	public Optional<Cat> findById(UUID id) {
		return catRepository.findById(id);
	}

	@Override
	public Cat create(Cat cat) {
		return catRepository.save(cat);
	}

	@Override
	public Optional<Cat> update(Cat cat) {
		return catRepository.findById(cat.getId()).map(c -> catRepository.save(cat));
	}

	@Override
	public Boolean delete(UUID id) {
		if(catRepository.existsById(id)) {
			catRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Cat> filterList(String name, Integer age, Gender gender, String breed, HairLength hairLength, Size size,
			Boolean isVaccinated, Boolean isCastrated) {
		return catRepository.findAll(CatSpecification.filterCat(name, age, gender, breed, hairLength, size, isVaccinated, isCastrated));
	}

}
