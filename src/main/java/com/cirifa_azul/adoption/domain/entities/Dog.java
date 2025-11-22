package com.cirifa_azul.adoption.domain.entities;

import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.HairLength;
import com.cirifa_azul.adoption.domain.entities.enums.Size;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DOG")
public class Dog extends Animal {
	String breed;
	Double weight;
	HairLength hairLength;
	Size size;
	Boolean isVaccinated;
	Boolean isCastrated;

	public Dog(User user, String name, String age, Double weight, Gender gender, String breed, HairLength hairLength,
			Boolean isVaccinated, Boolean isCastrated) {
		super(user, name, age, gender);
		this.breed = breed;
		this.hairLength = hairLength;
		this.weight = weight;
		this.size = Size.sizeCategory(this.weight);
		this.isVaccinated = isVaccinated;
		this.isCastrated = isCastrated;
	}

	public Dog(User user, String name, String age, Gender gender) {
		super(user, name, age, gender);
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
