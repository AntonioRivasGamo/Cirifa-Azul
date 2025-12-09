package com.cirifa_azul.adoption.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cirifa_azul.adoption.domain.dtos.OtherDTO;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;

public interface OtherService {

	List<OtherDTO> findAll();
	Optional<OtherDTO> findById(UUID id);
	OtherDTO create(OtherDTO otherDTO);
	Optional<OtherDTO> update(OtherDTO otherDTO);
	Boolean delete(UUID id);
	List<OtherDTO> filterList(String name,
			Integer age,
			Gender gender,
		    String species,
		    Diet diet);
}
