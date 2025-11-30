package com.cirifa_azul.adoption.mappers;

import com.cirifa_azul.adoption.domain.dtos.LoginResponseDTO;
import com.cirifa_azul.adoption.domain.dtos.RegisterRequestDTO;
import com.cirifa_azul.adoption.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthMapper {
    LoginResponseDTO toDto(User user);

}
