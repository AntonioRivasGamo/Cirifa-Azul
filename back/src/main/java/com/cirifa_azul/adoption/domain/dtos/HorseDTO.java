package com.cirifa_azul.adoption.domain.dtos;

import java.util.UUID;

import com.cirifa_azul.adoption.domain.entities.User;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.WaterType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HorseDTO {

	UUID id;
	UserDTO user;
	String name;
	Integer age;
	Gender gender;
	Byte[] mainPhoto;
	String breed;
	Double weight;
	Boolean isVaccinated;
	Boolean isCastrated;
}
