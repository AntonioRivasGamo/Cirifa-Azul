package com.cirifa_azul.adoption.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cirifa_azul.adoption.domain.dtos.DogDTO;
import com.cirifa_azul.adoption.domain.entities.Dog;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.HairLength;
import com.cirifa_azul.adoption.domain.entities.enums.Size;

public interface DogService {

	List<DogDTO> findAll();
	Optional<DogDTO> findById(UUID id);
	DogDTO create(DogDTO dogDto);
	Optional<DogDTO> update(DogDTO dogDto);
	Boolean delete(UUID id);
	List<DogDTO> filterList(Integer age,
			String breed,
			Gender gender,
			HairLength hairLength,
			Boolean isCastrated,
			Boolean isVaccinated,
			String name,
			Size size);
}
