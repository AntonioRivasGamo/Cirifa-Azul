package com.cirifa_azul.adoption.domain.dtos;

import com.cirifa_azul.adoption.domain.entities.User;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.HairLength;
import com.cirifa_azul.adoption.domain.entities.enums.Size;
import com.cirifa_azul.adoption.domain.entities.enums.WaterType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class AnimalDTO {

	
	Integer age;
	Boolean canFly;
	Boolean canSpeak;
	Boolean isCastrated;
	Boolean isVaccinated;
	Double weight;
	String type;
	String breed;
	Diet diet;
	Gender gender;
	HairLength hairLength;
	String moreDetails;
	String name;
	Size size;
	String species;
	WaterType waterType;
	Byte[] mainPhoto;
	User user;
}
