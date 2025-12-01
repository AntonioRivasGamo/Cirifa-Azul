package com.cirifa_azul.adoption.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cirifa_azul.adoption.domain.dtos.AnimalDTO;
import com.cirifa_azul.adoption.domain.entities.Animal;
import com.cirifa_azul.adoption.domain.entities.Cat;
import com.cirifa_azul.adoption.domain.entities.Dog;
import com.cirifa_azul.adoption.domain.entities.User;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.HairLength;
import com.cirifa_azul.adoption.mappers.AnimalMapper;
import com.cirifa_azul.adoption.services.AnimalService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/animal")
public class AnimalController {

	private final AnimalService animalService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Animal> getAnimalById(@PathVariable UUID id) {
		return animalService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping
	public ResponseEntity<Animal> updateAnimal(@RequestBody AnimalDTO animalDTO) {
		return ResponseEntity.ok(animalService.updateAnimal(AnimalMapper.toEntity(animalDTO)));
	}
}
