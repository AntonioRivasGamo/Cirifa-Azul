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

import com.cirifa_azul.adoption.domain.dtos.OtherDTO;
import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;
import com.cirifa_azul.adoption.services.OtherService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/animals/other")
@RequiredArgsConstructor
public class OtherController {
	
	private final OtherService otherService;

	@GetMapping("/filter")
	public ResponseEntity<List<OtherDTO>> filter(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer age,
			@RequestParam(required = false) Gender gender,
			@RequestParam(required = false) String species,
			@RequestParam(required = false) Diet diet
			) {
		return ResponseEntity.ok(otherService.filterList(name, age, gender, species, diet));
	}
	
	@GetMapping
	public ResponseEntity<List<OtherDTO>> list() {
		return ResponseEntity.ok(otherService.findAll());
	}
	
	@GetMapping("/{}id")
	public ResponseEntity<OtherDTO> find(@PathVariable UUID id) {
		try {
			return ResponseEntity.ok(otherService.findById(id).orElseThrow());
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new OtherDTO());
		}
	}
	
	@PostMapping
	public ResponseEntity<OtherDTO> create(@RequestBody OtherDTO otherDTO) {
		return ResponseEntity.ok(otherService.create(otherDTO));
	}
	
	@PutMapping
	public ResponseEntity<OtherDTO> update(@RequestBody OtherDTO otherDTO) {
		try {
			return ResponseEntity.ok(otherService.update(otherDTO).orElseThrow());
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new OtherDTO());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable UUID id) {
		if(Boolean.TRUE.equals(otherService.delete(id))) return ResponseEntity.ok().build();
		return ResponseEntity.notFound().build();
	}
}
