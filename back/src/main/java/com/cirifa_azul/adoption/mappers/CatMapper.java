package com.cirifa_azul.adoption.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.cirifa_azul.adoption.domain.dtos.CatDTO;
import com.cirifa_azul.adoption.domain.dtos.DogDTO;
import com.cirifa_azul.adoption.domain.entities.Cat;
import com.cirifa_azul.adoption.domain.entities.Dog;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface CatMapper {

	CatDTO toDTO(Cat cat);
	
	@InheritInverseConfiguration
	Cat toEntity(CatDTO catDTO);
}
