package com.cirifa_azul.adoption.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cirifa_azul.adoption.domain.dtos.HorseDTO;
import com.cirifa_azul.adoption.domain.entities.Horse;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.mappers.HorseMapper;
import com.cirifa_azul.adoption.repositories.HorseRepository;
import com.cirifa_azul.adoption.repositories.specifications.HorseSpecification;
import com.cirifa_azul.adoption.services.HorseService;
import com.cirifa_azul.adoption.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HorseServiceImpl implements HorseService{

	private final HorseRepository horseRepository;
	private final HorseMapper horseMapper;
	private final UserService userService;
	
	@Override
	public List<HorseDTO> findAll() {
		return horseRepository.findAll().stream().map(horseMapper::toDto).toList();
	}

	@Override
	public Optional<HorseDTO> findById(UUID id) {
		return horseRepository.findById(id).map(horseMapper::toDto);
	}

	@Override
	public HorseDTO create(HorseDTO horseDTO) {
		Horse horse = horseMapper.toEntity(horseDTO);
		horse.setUser(userService.findByEmail(horseDTO.getUser().getEmail()).orElseThrow());
		return horseMapper.toDto(horseRepository.save(horse));
	}

	@Override
	public Optional<HorseDTO> update(HorseDTO horseDTO) {
		return horseRepository.findById(horseDTO.getId()).map(h -> 
		horseMapper.toDto(horseRepository.save(horseMapper.toEntity(horseDTO))));
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
	public List<HorseDTO> filterList(String name, Integer age, Gender gender, String breed, Boolean isVaccinated,
			Boolean isCastrated) {
		return horseRepository.findAll(HorseSpecification.filterHorse(name, age, gender, breed, isVaccinated, isCastrated))
				.stream().map(horseMapper::toDto).toList();
	}
	
	
}
