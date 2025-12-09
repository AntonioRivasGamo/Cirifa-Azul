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

import com.cirifa_azul.adoption.domain.dtos.FishDTO;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.domain.entities.enums.WaterType;
import com.cirifa_azul.adoption.services.FishService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/animals/fish")
@RequiredArgsConstructor
public class FishController {

	private final FishService fishService;
	
	@GetMapping("/filter")
	public ResponseEntity<List<FishDTO>> filter(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer age,
			@RequestParam(required = false) Gender gender,
			@RequestParam(required = false) String species,
			@RequestParam(required = false) Diet diet,
			@RequestParam(required = false) WaterType waterType
			) {
		return ResponseEntity.ok(fishService.filterList(name, age, gender, species, diet, waterType));
	}
	
	@GetMapping
	public ResponseEntity<List<FishDTO>> list() {
		return ResponseEntity.ok(fishService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FishDTO> find(@PathVariable UUID id) {
		try {
			return ResponseEntity.ok(fishService.findById(id).orElseThrow());
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new FishDTO());
		}
	}
	
	@PostMapping
	public ResponseEntity<FishDTO> create(@RequestBody FishDTO fishDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(fishService.create(fishDTO));
	}
	
	@PutMapping
	public ResponseEntity<FishDTO> update(@RequestBody FishDTO fishDTO) {
		return ResponseEntity.ok(fishService.update(fishDTO).orElseThrow());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable UUID id) {
		if(Boolean.TRUE.equals(fishService.delete(id))) return ResponseEntity.ok().build();
		return ResponseEntity.notFound().build();
	}
	
	
}
