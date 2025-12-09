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

import com.cirifa_azul.adoption.domain.dtos.CatDTO;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.HairLength;
import com.cirifa_azul.adoption.domain.entities.enums.Size;
import com.cirifa_azul.adoption.services.CatService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/animals/cat")
@RequiredArgsConstructor
public class CatController {

	private final CatService catService;
	
	@GetMapping("/filter")
	public ResponseEntity<List<CatDTO>> filter(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer age,
			@RequestParam(required = false) Gender gender,
			@RequestParam(required = false) String breed,
			@RequestParam(required = false) HairLength hairLength,
			@RequestParam(required = false) Size size,
			@RequestParam(required = false) Boolean isVaccinated,
			@RequestParam(required = false) Boolean isCastrated) {
		return ResponseEntity.ok(catService.filterList(name, age, gender, breed, hairLength, size, isVaccinated, isCastrated));
	}
	
	@GetMapping
	public ResponseEntity<List<CatDTO>> list() {
		return ResponseEntity.ok(catService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CatDTO> find(@PathVariable UUID id) {
		try {
			return ResponseEntity.ok(catService.findById(id).orElseThrow());
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CatDTO());
		}
	}
	
	@PostMapping
	public ResponseEntity<CatDTO> create(@RequestBody CatDTO catDTO) {
		return ResponseEntity.ok(catService.create(catDTO));
	}
	
	@PutMapping
	public ResponseEntity<CatDTO> update(@RequestBody CatDTO catDTO) {
		try {
			return ResponseEntity.ok(catService.update(catDTO).orElseThrow());
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CatDTO());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable UUID id) {
		if(Boolean.TRUE.equals(catService.delete(id))) return ResponseEntity.ok().build();
		return ResponseEntity.notFound().build();
	}
}
