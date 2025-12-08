package com.cirifa_azul.adoption.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.cirifa_azul.adoption.domain.dtos.FishDTO;
import com.cirifa_azul.adoption.domain.entities.Fish;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface FishMapper {

	FishDTO toDto(Fish fish);
	
	@InheritInverseConfiguration
	Fish toEntity(FishDTO fishDTO);
}
