package com.cirifa_azul.adoption.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cirifa_azul.adoption.domain.dtos.OtherDTO;
import com.cirifa_azul.adoption.domain.entities.Other;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.mappers.OtherMapper;
import com.cirifa_azul.adoption.repositories.OtherRepository;
import com.cirifa_azul.adoption.repositories.specifications.OtherSpecification;
import com.cirifa_azul.adoption.services.OtherService;
import com.cirifa_azul.adoption.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OtherServiceImpl implements OtherService{

	private final OtherRepository otherRepository;
	private final OtherMapper otherMapper;
	private final UserService userService;
	
	@Override
	public List<OtherDTO> findAll() {
		return otherRepository.findAll().stream().map(otherMapper::toDto).toList();
	}

	@Override
	public Optional<OtherDTO> findById(UUID id) {
		return otherRepository.findById(id).map(otherMapper::toDto);
	}

	@Override
	public OtherDTO create(OtherDTO otherDTO) {
		Other other = otherMapper.toEntity(otherDTO);
		other.setUser(userService.findByEmail(otherDTO.getUser().getEmail()).orElseThrow());
		return otherMapper.toDto(otherRepository.save(other));
	}

	@Override
	public Optional<OtherDTO> update(OtherDTO otherDTO) {
		return otherRepository.findById(otherDTO.getId()).map(o -> 
		otherMapper.toDto(otherRepository.save(otherMapper.toEntity(otherDTO))));
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
	public List<OtherDTO> filterList(String name, Integer age, Gender gender, String species, Diet diet) {
		return otherRepository.findAll(OtherSpecification.filterOther(name, age, gender, species, diet))
				.stream().map(otherMapper::toDto).toList();
	}

}
