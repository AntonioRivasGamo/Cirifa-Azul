package com.cirifa_azul.adoption.mappers;

import com.cirifa_azul.adoption.domain.dtos.AnimalDTO;
import com.cirifa_azul.adoption.domain.entities.Animal;
import com.cirifa_azul.adoption.domain.entities.Dog;

public class AnimalMapper {

	public static Animal toEntity(AnimalDTO animalDTO) {
		return switch (animalDTO.getType()) {
		case "DOG": {
			Dog d = new Dog(animalDTO.getBreed(), animalDTO.getHairLength(), animalDTO.getIsCastrated(), animalDTO.getIsVaccinated(),
					animalDTO.getWeight(), animalDTO.getUser(), animalDTO.getName(), animalDTO.getAge(), animalDTO.getGender(), animalDTO.getMainPhoto());
			yield d;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + animalDTO.getType());
		};
	}
}
