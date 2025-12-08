package com.cirifa_azul.adoption.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cirifa_azul.adoption.domain.dtos.CatDTO;
import com.cirifa_azul.adoption.domain.entities.Cat;
import com.cirifa_azul.adoption.domain.entities.Dog;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.HairLength;
import com.cirifa_azul.adoption.domain.entities.enums.Size;
import com.cirifa_azul.adoption.mappers.CatMapper;
import com.cirifa_azul.adoption.repositories.CatRepository;
import com.cirifa_azul.adoption.repositories.specifications.CatSpecification;
import com.cirifa_azul.adoption.services.CatService;
import com.cirifa_azul.adoption.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CatServiceImpl implements CatService{

	private final CatRepository catRepository;
	private final CatMapper catMapper;
	private final UserService userService;
	
	@Override
	public List<CatDTO> findAll() {
		return catRepository.findAll().stream().map(catMapper::toDTO).toList();
	}

	@Override
	public Optional<CatDTO> findById(UUID id) {
		return catRepository.findById(id).map(catMapper::toDTO);
	}

	@Override
	public CatDTO create(CatDTO catDTO) {
		Cat cat = catMapper.toEntity(catDTO);
		cat.setSize(Size.sizeCategory(cat.getWeight()));
		cat.setUser(userService.findByEmail(catDTO.getUser().getEmail()).orElseThrow());
		return catMapper.toDTO(catRepository.save(cat));
	}

	@Override
	public Optional<CatDTO> update(CatDTO catDTO) {
		return catRepository.findById(catDTO.getId()).map(d -> 
		catMapper.toDTO(catRepository.save(catMapper.toEntity(catDTO))));
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
	public List<CatDTO> filterList(String name, Integer age, Gender gender, String breed, HairLength hairLength, Size size,
			Boolean isVaccinated, Boolean isCastrated) {
		return catRepository.findAll(CatSpecification.filterCat(name, age, gender, breed, hairLength, size, isVaccinated, isCastrated))
				.stream().map(catMapper::toDTO).toList();
	}

}
