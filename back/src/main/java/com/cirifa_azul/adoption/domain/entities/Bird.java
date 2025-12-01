package com.cirifa_azul.adoption.domain.entities;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.cirifa_azul.adoption.domain.entities.enums.Diet;
import com.cirifa_azul.adoption.domain.entities.enums.Gender;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("BIRD")
public class Bird{

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	UUID id;
	@ManyToOne
	User user;
	String name;
	Integer age;
	@Enumerated(EnumType.STRING)
	Gender gender;
	@Lob
	Byte[] mainPhoto;
	String breed;
	@Enumerated(EnumType.STRING)
	Diet diet;
	Boolean canSpeak;
	Boolean canFly;
	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;

}
