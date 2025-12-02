package com.cirifa_azul.adoption.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cirifa_azul.adoption.domain.entities.Bird;
import com.cirifa_azul.adoption.domain.entities.Other;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;

public interface OtherService {

	List<Other> findAll();
	Optional<Other> findById(UUID id);
	Other create(Other other);
	Optional<Other> update(Other other);
	Boolean delete(UUID id);
	List<Other> filterList(String name,
			Integer age,
			Gender gender,
		    String species,
		    Diet diet);
}
