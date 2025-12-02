package com.cirifa_azul.adoption.repositories.specifications;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.cirifa_azul.adoption.domain.entities.Bird;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;

import jakarta.persistence.criteria.Predicate;

public class BirdSpecification {

	public static Specification<Bird> filterBird(
			String name,
			Integer age,
			Gender gender,
			String breed,
			Diet diet,
			Boolean canSpeak,
			Boolean canFly
			){
		return (root, query, builder) -> {
			List<Predicate> predicates = new LinkedList<>();
			if(name != null) predicates.add(builder.equal(root.get("name"), name));
			if(age != null) predicates.add(builder.equal(root.get("age"), age));
			if(gender != null) predicates.add(builder.equal(root.get("gender"), gender));
			if(breed != null) predicates.add(builder.equal(root.get("breed"), breed));
			if(diet != null) predicates.add(builder.equal(root.get("diet"), diet));
			if(canSpeak != null) predicates.add(builder.equal(root.get("canSpeak"), canSpeak));
			if(canFly != null) predicates.add(builder.equal(root.get("canFly"), canFly));
			return builder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
