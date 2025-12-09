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

import com.cirifa_azul.adoption.domain.dtos.BirdDTO;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.services.BirdService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/animals/bird")
@RequiredArgsConstructor
public class BirdController {

	private final BirdService birdService;
	
	@GetMapping("/filter")
	public ResponseEntity<List<BirdDTO>> filter(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer age,
			@RequestParam(required = false) Gender gender,
			@RequestParam(required = false) String breed,
			@RequestParam(required = false) Diet diet,
			@RequestParam(required = false) Boolean canSpeak,
			@RequestParam(required = false) Boolean canFly
			) {
		return ResponseEntity.ok(birdService.filterList(name, age, gender, breed, diet, canSpeak, canFly));
	}
	
	@GetMapping
	public ResponseEntity<List<BirdDTO>> list() {
		return ResponseEntity.ok(birdService.findAll());
	}
	
	@GetMapping("/{}id")
	public ResponseEntity<BirdDTO> find(@PathVariable UUID id) {
		try {
			return ResponseEntity.ok(birdService.findById(id).orElseThrow());
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BirdDTO());
		}
	}
	
	@PostMapping
	public ResponseEntity<BirdDTO> create(@RequestBody BirdDTO birdDTO) {
		return ResponseEntity.ok(birdService.create(birdDTO));
	}
	
	@PutMapping
	public ResponseEntity<BirdDTO> update(@RequestBody BirdDTO birdDTO) {
		try {
			return ResponseEntity.ok(birdService.update(birdDTO).orElseThrow());
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BirdDTO());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable UUID id) {
		if(Boolean.TRUE.equals(birdService.delete(id))) return ResponseEntity.ok().build();
		return ResponseEntity.notFound().build();
	}
}
