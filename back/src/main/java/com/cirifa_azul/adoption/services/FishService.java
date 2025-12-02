package com.cirifa_azul.adoption.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cirifa_azul.adoption.domain.entities.Cat;
import com.cirifa_azul.adoption.domain.entities.Dog;
import com.cirifa_azul.adoption.domain.entities.Fish;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.HairLength;
import com.cirifa_azul.adoption.domain.entities.enums.Size;
import com.cirifa_azul.adoption.domain.entities.enums.WaterType;

public interface FishService {

	List<Fish> findAll();
	Optional<Fish> findById(UUID id);
	Fish create(Fish fish);
	Optional<Fish> update(Fish fish);
	Boolean delete(UUID id);
	List<Fish> filterList(String name,
			Integer age,
			Gender gender,
		    String species,
		    Diet diet,
		    WaterType waterType);
}
