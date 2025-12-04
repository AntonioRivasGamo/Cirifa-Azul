package com.cirifa_azul.adoption.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cirifa_azul.adoption.domain.entities.Other;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.repositories.OtherRepository;
import com.cirifa_azul.adoption.repositories.specifications.OtherSpecification;
import com.cirifa_azul.adoption.services.OtherService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OtherServiceImpl implements OtherService{

	private final OtherRepository otherRepository;
	
	@Override
	public List<Other> findAll() {
		return otherRepository.findAll();
	}

	@Override
	public Optional<Other> findById(UUID id) {
		return otherRepository.findById(id);
	}

	@Override
	public Other create(Other other) {
		return otherRepository.save(other);
	}

	@Override
	public Optional<Other> update(Other other) {
		return otherRepository.findById(other.getId()).map(o -> otherRepository.save(other));
	}

	@Override
	public Boolean delete(UUID id) {
		if(otherRepository.existsById(id)) {
			otherRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Other> filterList(String name, Integer age, Gender gender, String species, Diet diet) {
		return otherRepository.findAll(OtherSpecification.filterOther(name, age, gender, species, diet));
	}

}
