package com.cirifa_azul.adoption.mappers;

import com.cirifa_azul.adoption.domain.dtos.AuthResponseDTO;
import com.cirifa_azul.adoption.domain.dtos.RegisterRequestDTO;
import com.cirifa_azul.adoption.domain.entities.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthMapper {
    User fromDto(RegisterRequestDTO dto);

    @Mapping(target = "accessToken", ignore = true)
    @Mapping(target = "refreshToken", ignore = true)
    @Mapping(target = "tokenType", constant = "Bearer")
    AuthResponseDTO toDto(User user);

    @AfterMapping
    default AuthResponseDTO setTokens(@MappingTarget AuthResponseDTO dto,
                                      String accessToken,
                                      String refreshToken) {
        dto.setAccessToken(accessToken);
        dto.setRefreshToken(refreshToken);
        return dto;
    }
}