package com.cirifa_azul.adoption.domain.entities;

import java.sql.Blob;

import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("Other")
public class Other extends Animal {

    String species;
    @Enumerated(EnumType.STRING)
    Diet diet;
    String moreDetails;

    public Other(Diet diet, String moreDetails, String species, User user, String name, String age, Gender gender, Blob mainPhoto) {
        super(user, name, age, gender, mainPhoto);
        this.diet = diet;
        this.moreDetails = moreDetails;
        this.species = species;
    }

    public Other() {
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

    public String getMoreDetails() {
        return moreDetails;
    }

    public void setMoreDetails(String moreDetails) {
        this.moreDetails = moreDetails;
    }

}
