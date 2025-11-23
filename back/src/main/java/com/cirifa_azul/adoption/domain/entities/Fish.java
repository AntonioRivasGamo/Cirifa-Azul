package com.cirifa_azul.adoption.domain.entities;

import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.WaterType;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("FISH")
public class Fish extends Animal {

	String species;
	@Enumerated(EnumType.STRING)
	Diet diet;
	@Enumerated(EnumType.STRING)
	WaterType waterType;

	public Fish(User user, String name, String age, Gender gender, String species, Diet diet, WaterType waterType) {
		super(user, name, age, gender);
		this.species = species;
		this.diet = diet;
		this.waterType = waterType;
	}

	public Fish(User user, String name, String age, Gender gender) {
		super(user, name, age, gender);
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public Diet getDiet() {
		return diet;
	}

	public void setDiet(Diet diet) {
		this.diet = diet;
	}

	public WaterType getWaterType() {
		return waterType;
	}

	public void setWaterType(WaterType waterType) {
		this.waterType = waterType;
	}

}
