package com.cirifa_azul.adoption.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyDiscriminatorValue;
import org.hibernate.annotations.AnyKeyJavaClass;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Favourite {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	UUID id;
	@ManyToOne
	User user;
	@Any
	@AnyKeyJavaClass(UUID.class)
	@JoinColumn(name = "animal_id")
	@AnyDiscriminatorValue(discriminator = "BIRD", entity = Bird.class)
	@AnyDiscriminatorValue(discriminator = "CAT", entity = Cat.class)
	@AnyDiscriminatorValue(discriminator = "DOG", entity = Dog.class)
	@AnyDiscriminatorValue(discriminator = "FARM", entity = Farm.class)
	@AnyDiscriminatorValue(discriminator = "FISH", entity = Fish.class)
	@AnyDiscriminatorValue(discriminator = "OTHER", entity = Other.class)
	Object animal;


	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

}
