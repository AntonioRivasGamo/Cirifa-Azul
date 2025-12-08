package com.cirifa_azul.adoption.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cirifa_azul.adoption.domain.dtos.BirdDTO;
import com.cirifa_azul.adoption.domain.entities.Bird;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.mappers.BirdMapper;
import com.cirifa_azul.adoption.repositories.BirdRepository;
import com.cirifa_azul.adoption.repositories.UserRepository;
import com.cirifa_azul.adoption.repositories.specifications.BirdSpecification;
import com.cirifa_azul.adoption.services.BirdService;
import com.cirifa_azul.adoption.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BirdServiceImpl implements BirdService{
	
	private final BirdRepository birdRepository;
	private final BirdMapper birdMapper;
	private final UserService userService;

	@Override
	public List<BirdDTO> findAll() {
		return birdRepository.findAll().stream().map(birdMapper::toDto).toList();
	}

	@Override
	public Optional<BirdDTO> findById(UUID id) {
		return birdRepository.findById(id).map(birdMapper::toDto);
	}

	@Override
	public BirdDTO create(BirdDTO birdDTO) {
		Bird bird = birdMapper.toEntity(birdDTO);
		bird.setUser(userService.findByEmail(birdDTO.getUser().getEmail()).orElseThrow());
		return birdMapper.toDto(birdRepository.save(bird));
	}

	@Override
	public Optional<BirdDTO> update(BirdDTO birdDTO) {
		return birdRepository.findById(birdDTO.getId()).map(b -> 
		birdMapper.toDto(birdRepository.save(birdMapper.toEntity(birdDTO))));
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
	public List<BirdDTO> filterList(String name, Integer age, Gender gender, String breed, Diet diet, Boolean canSpeak,
			Boolean canFly) {
		return birdRepository.findAll(BirdSpecification.filterBird(name, age, gender, breed, diet, canSpeak, canFly))
				.stream().map(birdMapper::toDto).toList();
	}

}
