package com.cirifa_azul.adoption.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.cirifa_azul.adoption.domain.dtos.HorseDTO;
import com.cirifa_azul.adoption.domain.entities.Horse;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface HorseMapper {

	HorseDTO toDto(Horse horse);
	
	@InheritInverseConfiguration
	Horse toEntity(HorseDTO horseDTO);
}
