package com.cirifa_azul.adoption.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.cirifa_azul.adoption.domain.dtos.BirdDTO;
import com.cirifa_azul.adoption.domain.entities.Bird;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface BirdMapper {

	BirdDTO toDto(Bird bird);
	
	@InheritInverseConfiguration
	Bird toEntity(BirdDTO birdDTO);
}
