package com.cirifa_azul.adoption.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cirifa_azul.adoption.domain.dtos.HorseDTO;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.services.HorseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/animals/horse")
@RequiredArgsConstructor
public class HorseController {
	
	private final HorseService horseService;

	@GetMapping("/filter")
	public ResponseEntity<List<HorseDTO>> filter(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer age,
			@RequestParam(required = false) Gender gender,
			@RequestParam(required = false) String breed,
			@RequestParam(required = false) Boolean isVaccinated,
			@RequestParam(required = false) Boolean isCastrated
			) {
		return ResponseEntity.ok(horseService.filterList(name, age, gender, breed, isVaccinated, isCastrated));
	}
	
	@GetMapping
	public ResponseEntity<List<HorseDTO>> list() {
		return ResponseEntity.ok(horseService.findAll());
	}
	
	@GetMapping("/{}id")
	public ResponseEntity<HorseDTO> find(@PathVariable UUID id) {
		try {
			return ResponseEntity.ok(horseService.findById(id).orElseThrow());
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HorseDTO());
		}
	}
	
	@PostMapping
	public ResponseEntity<HorseDTO> create(@RequestBody HorseDTO horseDTO) {
		return ResponseEntity.ok(horseService.create(horseDTO));
	}
	
	@PutMapping
	public ResponseEntity<HorseDTO> update(@RequestBody HorseDTO horseDTO) {
		try {
			return ResponseEntity.ok(horseService.update(horseDTO).orElseThrow());
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HorseDTO());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable UUID id) {
		if(Boolean.TRUE.equals(horseService.delete(id))) return ResponseEntity.ok().build();
		return ResponseEntity.notFound().build();
	}
}
