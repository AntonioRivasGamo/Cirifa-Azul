package com.cirifa_azul.adoption.mappers;

import org.mapstruct.AfterMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.cirifa_azul.adoption.domain.dtos.UserDTO;
import com.cirifa_azul.adoption.domain.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	@Mapping(target = "name", source = "firstName")
	UserDTO toDTO(User user);
	
	@InheritInverseConfiguration
	@Mapping(target = "role", ignore = true)
	User toEntity(UserDTO user);
	
}
