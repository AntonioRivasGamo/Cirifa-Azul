package com.cirifa_azul.adoption.domain.entities;

import java.sql.Blob;

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

    public Bird(String breed, Boolean canFly, Boolean canSpeak, Diet diet, User user, String name, Integer age, 
    		Gender gender, Byte[] mainPhoto) {
        super(user, name, age, gender, mainPhoto);
        this.breed = breed;
        this.canFly = canFly;
        this.canSpeak = canSpeak;
        this.diet = diet;
    }

    public Bird() {
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
