package com.cirifa_azul.adoption.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cirifa_azul.adoption.domain.dtos.DogDTO;
import com.cirifa_azul.adoption.domain.entities.Dog;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.HairLength;
import com.cirifa_azul.adoption.domain.entities.enums.Size;
import com.cirifa_azul.adoption.mappers.DogMapper;
import com.cirifa_azul.adoption.repositories.DogRepository;
import com.cirifa_azul.adoption.repositories.specifications.DogSpecification;
import com.cirifa_azul.adoption.services.DogService;
import com.cirifa_azul.adoption.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DogServiceImpl implements DogService{

    private final UserService userService;

	private final DogRepository dogRepository;
	private final DogMapper dogMapper;
	
	@Override
	public List<DogDTO> findAll() {
		return dogRepository.findAll().stream().map(dogMapper::toDTO).toList();
	}
	@Override
	public Optional<DogDTO> findById(UUID id) {
		return dogRepository.findById(id).map(dogMapper::toDTO);
	}
	@Override
	public DogDTO create(DogDTO dogDto) {
		Dog dog = dogMapper.toEntity(dogDto);
		dog.setSize(Size.sizeCategory(dog.getWeight()));
		dog.setUser(userService.findByEmail(dogDto.getUser().getEmail()).orElseThrow());
		return dogMapper.toDTO(dogRepository.save(dog));
	}
	@Override
	public Optional<DogDTO> update(DogDTO dogDto) {
		return dogRepository.findById(dogDto.getId()).map(d -> 
		dogMapper.toDTO(dogRepository.save(dogMapper.toEntity(dogDto))));
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
	public List<DogDTO> filterList(Integer age, String breed, Gender gender, HairLength hairLength, Boolean isCastrated,
			Boolean isVaccinated, String name, Size size) {
		return dogRepository.findAll(DogSpecification.filterDogs(age, breed, gender, hairLength, isCastrated, isVaccinated, name, size))
				.stream().map(dogMapper::toDTO).toList();
	} 

	
}
