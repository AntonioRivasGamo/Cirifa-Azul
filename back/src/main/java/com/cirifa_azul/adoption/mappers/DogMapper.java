package com.cirifa_azul.adoption.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.cirifa_azul.adoption.domain.dtos.DogDTO;
import com.cirifa_azul.adoption.domain.entities.Dog;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface DogMapper {
	
	DogDTO toDTO(Dog dog);
	
	@InheritInverseConfiguration
	Dog toEntity(DogDTO dog);
}
