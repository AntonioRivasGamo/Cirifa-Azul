package com.cirifa_azul.adoption.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cirifa_azul.adoption.domain.entities.Fish;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.WaterType;
import com.cirifa_azul.adoption.repositories.FishRepository;
import com.cirifa_azul.adoption.repositories.specifications.FishSpecification;
import com.cirifa_azul.adoption.services.FishService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FishServiceImpl implements FishService{

    private final FishRepository fishRepository;

    @Override
	public List<Fish> findAll() {
		return fishRepository.findAll();
	}

	@Override
	public Optional<Fish> findById(UUID id) {
		return fishRepository.findById(id);
	}

	@Override
	public Fish create(Fish fish) {
		return fishRepository.save(fish);
	}

	@Override
	public Optional<Fish> update(Fish fish) {
		return fishRepository.findById(fish.getId()).map(f -> fishRepository.save(fish));
	}

	@Override
	public Boolean delete(UUID id) {
		if(fishRepository.existsById(id)) {
			fishRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Fish> filterList(String name, Integer age, Gender gender, String species, Diet diet,
			WaterType waterType) {
		return fishRepository.findAll(FishSpecification.filterFish(name, age, gender, species, diet, waterType));
	}

}
