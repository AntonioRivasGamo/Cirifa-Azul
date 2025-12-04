package com.cirifa_azul.adoption.domain.dtos;

import java.util.UUID;

import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.HairLength;
import com.cirifa_azul.adoption.domain.entities.enums.Size;

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
public class DogDTO {

	UUID id;
	Integer age;
	String name;
	String breed;
	Gender gender;
	HairLength hairLength;
	Byte[] mainPhoto;
	Size size;
	Double weight;
	Boolean isCastrated;
	Boolean isVaccinated;
	UserDTO user;
}
