package com.cirifa_azul.adoption.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class LoginResponseDTO {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("refreshToken")
    private String refreshToken;

    @JsonProperty("token_type")
    private String tokenType = "Bearer";

    private Long userId;
    private String username;
    private String role;
}
