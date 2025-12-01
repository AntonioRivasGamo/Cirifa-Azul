package com.cirifa_azul.adoption.domain.entities;

import java.sql.Blob;

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

    public Farm(Diet diet, Boolean isVaccinated, String species, 
    		User user, String name, Integer age, Gender gender, Blob mainPhoto) {
        super(user, name, age, gender, mainPhoto);
        this.diet = diet;
        this.isVaccinated = isVaccinated;
        this.species = species;
    }

    public Farm() {
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
