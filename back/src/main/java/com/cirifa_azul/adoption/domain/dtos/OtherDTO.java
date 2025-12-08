package com.cirifa_azul.adoption.domain.dtos;

import java.util.UUID;

import com.cirifa_azul.adoption.domain.entities.User;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
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
public class OtherDTO {

	UUID id;
	User user;
	String name;
	Integer age;
	Gender gender;
	Byte[] mainPhoto;
    String species;
    Diet diet;
    String moreDetails;
}
