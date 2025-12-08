package com.cirifa_azul.adoption.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cirifa_azul.adoption.domain.dtos.FishDTO;
import com.cirifa_azul.adoption.domain.entities.Fish;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.WaterType;
import com.cirifa_azul.adoption.mappers.FishMapper;
import com.cirifa_azul.adoption.repositories.FishRepository;
import com.cirifa_azul.adoption.repositories.specifications.FishSpecification;
import com.cirifa_azul.adoption.services.FishService;
import com.cirifa_azul.adoption.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FishServiceImpl implements FishService{

    private final FishRepository fishRepository;
    private final FishMapper fishMapper;
    private final UserService userService;

    @Override
	public List<FishDTO> findAll() {
		return fishRepository.findAll().stream().map(fishMapper::toDto).toList();
	}

	@Override
	public Optional<FishDTO> findById(UUID id) {
		return fishRepository.findById(id).map(fishMapper::toDto);
	}

	@Override
	public FishDTO create(FishDTO fishDTO) {
		Fish fish = fishMapper.toEntity(fishDTO);
		fish.setUser(userService.findByEmail(fishDTO.getUser().getEmail()).orElseThrow());
		return fishMapper.toDto(fishRepository.save(fish));
	}

	@Override
	public Optional<FishDTO> update(FishDTO fishDTO) {
		return fishRepository.findById(fishDTO.getId()).map(f -> fishRepository.save(fishMapper.toEntity(fishDTO))).map(fishMapper::toDto);
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
	public List<FishDTO> filterList(String name, Integer age, Gender gender, String species, Diet diet,
			WaterType waterType) {
		return fishRepository.findAll(FishSpecification.filterFish(name, age, gender, species, diet, waterType))
				.stream().map(fishMapper::toDto).toList();
	}

}
