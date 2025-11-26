package com.cirifa_azul.adoption.domain.entities;

import java.sql.Blob;

import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.HairLength;
import com.cirifa_azul.adoption.domain.entities.enums.Size;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("CAT")
public class Cat extends Animal {

	String breed;
	Double weight;
	@Enumerated(EnumType.STRING)
	HairLength hairLength;
	@Enumerated(EnumType.STRING)
	Size size;
	Boolean isVaccinated;
	Boolean isCastrated;

    public Cat(String breed, HairLength hairLength, Boolean isCastrated, Boolean isVaccinated, Size size, Double weight, User user, String name, String age, Gender gender, Blob mainPhoto) {
        super(user, name, age, gender, mainPhoto);
        this.breed = breed;
        this.hairLength = hairLength;
        this.isCastrated = isCastrated;
        this.isVaccinated = isVaccinated;
        this.size = size;
        this.weight = weight;
    }

    public Cat() {
    }

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public HairLength getHairLength() {
		return hairLength;
	}

	public void setHairLength(HairLength hairLength) {
		this.hairLength = hairLength;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Boolean getIsVaccinated() {
		return isVaccinated;
	}

	public void setIsVaccinated(Boolean isVaccinated) {
		this.isVaccinated = isVaccinated;
	}

	public Boolean getIsCastrated() {
		return isCastrated;
	}

	public void setIsCastrated(Boolean isCastrated) {
		this.isCastrated = isCastrated;
	}


}
