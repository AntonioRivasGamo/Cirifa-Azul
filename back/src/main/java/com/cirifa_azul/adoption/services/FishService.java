package com.cirifa_azul.adoption.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cirifa_azul.adoption.domain.dtos.FishDTO;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.WaterType;

public interface FishService {

	List<FishDTO> findAll();
	Optional<FishDTO> findById(UUID id);
	FishDTO create(FishDTO fishDTO);
	Optional<FishDTO> update(FishDTO fishDTO);
	Boolean delete(UUID id);
	List<FishDTO> filterList(String name,
			Integer age,
			Gender gender,
		    String species,
		    Diet diet,
		    WaterType waterType);
}
