package com.cirifa_azul.adoption.repositories.specifications;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.cirifa_azul.adoption.domain.entities.Other;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;

import jakarta.persistence.criteria.Predicate;

public class OtherSpecification {

	public static Specification<Other> filterOther(
			String name,
			Integer age,
			Gender gender,
		    String species,
		    Diet diet
			) {
		return (root, query, builder) -> {
			List<Predicate> predicates = new LinkedList<>();
			if(name != null) builder.equal(root.get("name"), name);
			if(age != null) builder.equal(root.get("age"), age);
			if(gender != null) builder.equal(root.get("gender"), gender);
			if(species != null) builder.equal(root.get("species"), species);
			if(diet != null) builder.equal(root.get("diet"), diet);
			return builder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
