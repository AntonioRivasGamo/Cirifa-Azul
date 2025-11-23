package com.cirifa_azul.adoption.domain.entities;

import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("FARM")
public class Farm extends Animal {

	String species;
	@Enumerated(EnumType.STRING)
	Diet diet;
	Boolean isVaccinated;

	public Farm(User user, String name, String age, Gender gender, String species, Diet diet,
			Boolean isVaccinated) {
		super(user, name, age, gender);
		this.species = species;
		this.diet = diet;
		this.isVaccinated = isVaccinated;
	}

	public Farm(User user, String name, String age, Gender gender) {
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

	public Boolean getIsVaccinated() {
		return isVaccinated;
	}

	public void setIsVaccinated(Boolean isVaccinated) {
		this.isVaccinated = isVaccinated;
	}

}
