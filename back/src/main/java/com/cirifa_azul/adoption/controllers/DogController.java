package com.cirifa_azul.adoption.controllers;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cirifa_azul.adoption.domain.dtos.DogDTO;
import com.cirifa_azul.adoption.domain.entities.Dog;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.HairLength;
import com.cirifa_azul.adoption.domain.entities.enums.Size;
import com.cirifa_azul.adoption.services.DogService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/animals/dog")
@RequiredArgsConstructor
public class DogController {

	private final DogService dogService;
	
	@GetMapping("/filter")
	public ResponseEntity<List<DogDTO>> filter(
	        @RequestParam(required = false) Integer age,
	        @RequestParam(required = false) String breed,
	        @RequestParam(required = false) Gender gender,
	        @RequestParam(required = false) HairLength hairLength,
	        @RequestParam(required = false) Boolean isCastrated,
	        @RequestParam(required = false) Boolean isVaccinated,
	        @RequestParam(required = false) String name,
	        @RequestParam(required = false) Size size) {

	    return ResponseEntity.ok(dogService.filterList(age, breed, gender, hairLength, isCastrated, isVaccinated, name, size));
	}
	
	@GetMapping
	public ResponseEntity<List<DogDTO>> list() {
		return ResponseEntity.ok(dogService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> find(@PathVariable UUID id) {
		try {
			return ResponseEntity.ok(dogService.findById(id).orElseThrow());
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Dog());
		}
	}
	
	@PostMapping
	public ResponseEntity<DogDTO> create(@RequestBody DogDTO dogDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(dogService.create(dogDto));
	}
	
	@PutMapping
	public ResponseEntity<DogDTO> update(@RequestBody DogDTO dogDto) {
		return ResponseEntity.ok(dogService.update(dogDto).orElseThrow());
	}
}
