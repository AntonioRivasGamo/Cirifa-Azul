package com.cirifa_azul.adoption.domain.dtos;

import java.util.UUID;

import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.HairLength;
import com.cirifa_azul.adoption.domain.entities.enums.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CatDTO {

	UUID id;
	UserDTO user;
	String name;
	Integer age;
	Gender gender;
	Byte[] mainPhoto;
	String breed;
	Double weight;
	HairLength hairLength;
	Size size;
	Boolean isVaccinated;
	Boolean isCastrated;
}
