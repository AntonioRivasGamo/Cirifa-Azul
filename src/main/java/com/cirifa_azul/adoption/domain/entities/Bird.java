package com.cirifa_azul.adoption.domain.entities;

import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("BIRD")
public class Bird extends Animal {

	String breed;
	@Enumerated(EnumType.STRING)
	Diet diet;
	Boolean canSpeak;
	Boolean canFly;

	public Bird(User user, String name, String age, Gender gender, String breed, Diet diet,
			Boolean canSpeak, Boolean canFly) {
		super(user, name, age, gender);
		this.breed = breed;
		this.diet = diet;
		this.canSpeak = canSpeak;
		this.canFly = canFly;
	}

	public Bird(User user, String name, String age, Gender gender) {
		super(user, name, age, gender);
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Diet getDiet() {
		return diet;
	}

	public void setDiet(Diet diet) {
		this.diet = diet;
	}

	public Boolean getCanSpeak() {
		return canSpeak;
	}

	public void setCanSpeak(Boolean canSpeak) {
		this.canSpeak = canSpeak;
	}

	public Boolean getCanFly() {
		return canFly;
	}

	public void setCanFly(Boolean canFly) {
		this.canFly = canFly;
	}
}
