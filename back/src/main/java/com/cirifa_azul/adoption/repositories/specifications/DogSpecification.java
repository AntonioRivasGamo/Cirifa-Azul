package com.cirifa_azul.adoption.repositories.specifications;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.cirifa_azul.adoption.domain.entities.Dog;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.HairLength;
import com.cirifa_azul.adoption.domain.entities.enums.Size;

import jakarta.persistence.criteria.Predicate;

public class DogSpecification {

	public static Specification<Dog> filterDogs(
			Integer age,
			String breed,
			Gender gender,
			HairLength hairLength,
			Boolean isCastrated,
			Boolean isVaccinated,
			String name,
			Size size,
			Double weight
			) {
		return (root, query, builder) -> {
			List<Predicate> predicates = new LinkedList<>();
			if(age != null) predicates.add(builder.equal(root.get("age"), age));
			if(breed != null) predicates.add(builder.equal(root.get("breed"), breed));
			if(gender != null) predicates.add(builder.equal(root.get("gender"), gender));
			if(hairLength != null) predicates.add(builder.equal(root.get("hairLength"), hairLength));
			if(isCastrated != null) predicates.add(builder.equal(root.get("isCastrated"), isCastrated));
			if(isVaccinated != null) predicates.add(builder.equal(root.get("isVaccinated"), isVaccinated));
			if(name != null) predicates.add(builder.equal(root.get("name"), name));
			if(size != null) predicates.add(builder.equal(root.get("size"), size));
			if(weight != null) predicates.add(builder.equal(root.get("weight"), weight));
			return builder.and(predicates.toArray(new Predicate[0]));
		};
	}
}