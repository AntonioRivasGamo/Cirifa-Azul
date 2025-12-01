package com.cirifa_azul.adoption.repositories.specifications;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.cirifa_azul.adoption.domain.entities.Animal;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.HairLength;
import com.cirifa_azul.adoption.domain.entities.enums.Size;
import com.cirifa_azul.adoption.domain.entities.enums.WaterType;

import jakarta.persistence.criteria.Predicate;

public class AnimalSpecifications {

	public static Specification<Animal> filter(Gender gender, Integer age, Boolean canFly, Boolean canSpeak, Diet diet,
			HairLength hairLength, Boolean isCastrated, Boolean isVaccinated, Size size, Double weight, WaterType waterType) {
		return (root, query, builder) -> {
			List<Predicate> predicates = new ArrayList();
			
			if(gender != null) {
				predicates.add(builder.equal(root.get("gender"), gender));
			}
			if(age != null) {
				predicates.add(builder.equal(root.get("age"), age));
			}
			if(canFly != null) {
				predicates.add(builder.equal(root.get("canFly"), canFly));
			}
			if(canSpeak != null) {
				predicates.add(builder.equal(root.get("canSpeak"), canSpeak));
			}
			if(diet != null) {
				predicates.add(builder.equal(root.get("diet"), diet));
			}
			if(hairLength != null) {
				predicates.add(builder.equal(root.get("hairLength"), hairLength));
			}
			if(isCastrated != null) {
				predicates.add(builder.equal(root.get("isCastrated"), isCastrated));
			}
			if(isVaccinated != null) {
				predicates.add(builder.equal(root.get("isVaccinated"), isVaccinated));
			}
			if(size != null) {
				predicates.add(builder.equal(root.get("size"), size));
			}
			if(weight != null) {
				predicates.add(builder.equal(root.get("weight"), weight));
			}
			if(waterType != null) {
				predicates.add(builder.equal(root.get("waterType"), waterType));
			}
			return builder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
