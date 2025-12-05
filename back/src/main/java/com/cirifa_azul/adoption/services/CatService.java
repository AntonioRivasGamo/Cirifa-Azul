package com.cirifa_azul.adoption.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cirifa_azul.adoption.domain.dtos.CatDTO;
import com.cirifa_azul.adoption.domain.entities.Cat;
import com.cirifa_azul.adoption.domain.entities.Dog;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.HairLength;
import com.cirifa_azul.adoption.domain.entities.enums.Size;

public interface CatService {

	List<CatDTO> findAll();
	Optional<CatDTO> findById(UUID id);
	CatDTO create(CatDTO catDTO);
	Optional<CatDTO> update(CatDTO catDTO);
	Boolean delete(UUID id);
	List<CatDTO> filterList(String name,
			Integer age,
			Gender gender,
			String breed,
			HairLength hairLength,
			Size size,
			Boolean isVaccinated,
			Boolean isCastrated);
}
