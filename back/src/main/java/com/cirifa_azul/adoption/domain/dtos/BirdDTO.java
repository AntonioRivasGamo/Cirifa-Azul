package com.cirifa_azul.adoption.domain.dtos;

import java.util.UUID;


import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BirdDTO {

	UUID id;
	UserDTO user;
	String name;
	Integer age;
	Gender gender;
	Byte[] mainPhoto;
	String breed;
	Diet diet;
	Boolean canSpeak;
	Boolean canFly;
}
