package com.cirifa_azul.adoption.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.cirifa_azul.adoption.domain.dtos.OtherDTO;
import com.cirifa_azul.adoption.domain.entities.Other;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface OtherMapper {

	OtherDTO toDto(Other other);
	
	@InheritInverseConfiguration
	Other toEntity(OtherDTO otherDTO);
}
