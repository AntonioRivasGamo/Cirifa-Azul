package com.cirifa_azul.adoption.repositories.specifications;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.cirifa_azul.adoption.domain.entities.Fish;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.WaterType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import jakarta.persistence.criteria.Predicate;

public class FishSpecification {

	public static Specification<Fish> filterFish(
			String name,
			Integer age,
			Gender gender,
		    String species,
		    Diet diet,
		    WaterType waterType
			) {
		return (root, query, builder) -> {
			List<Predicate> predicates = new LinkedList<>();
			if(name != null) predicates.add(builder.equal(root.get("name"), name));
			if(age != null) predicates.add(builder.equal(root.get("age"), age));
			if(gender != null) predicates.add(builder.equal(root.get("gender"), gender));
			if(species != null) predicates.add(builder.equal(root.get("species"), species));
			if(diet != null) predicates.add(builder.equal(root.get("diet"), diet));
			if(waterType != null) predicates.add(builder.equal(root.get("waterType"), waterType));
			return builder.and(predicates.toArray(new Predicate[0]));
		};
	}
	
}
