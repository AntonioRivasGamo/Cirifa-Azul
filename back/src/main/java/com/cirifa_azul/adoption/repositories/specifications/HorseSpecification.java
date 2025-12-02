package com.cirifa_azul.adoption.repositories.specifications;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.cirifa_azul.adoption.domain.entities.Horse;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;

import jakarta.persistence.criteria.Predicate;

public class HorseSpecification {

	public static Specification<Horse> filterHorse(
			String name,
			Integer age,
			Gender gender,
			String breed,
			Boolean isVaccinated,
			Boolean isCastrated
			) {
		return (root, query, builder) -> {
			List<Predicate> predicates = new LinkedList<>();
			if(name != null) predicates.add(builder.equal(root.get("name"), name));
			if(age != null) predicates.add(builder.equal(root.get("age"), age));
			if(gender != null) predicates.add(builder.equal(root.get("gender"), gender));
			if(breed != null) predicates.add(builder.equal(root.get("breed"), breed));
			if(isVaccinated != null) predicates.add(builder.equal(root.get("isVaccinated"), isVaccinated));
			if(isCastrated != null) predicates.add(builder.equal(root.get("isCastrated"), isCastrated));
			return builder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
