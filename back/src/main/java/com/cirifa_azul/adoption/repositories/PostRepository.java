package com.cirifa_azul.adoption.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cirifa_azul.adoption.domain.entities.Animal;
import com.cirifa_azul.adoption.domain.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID>{

	@Query("Select p from Post p where p.animal in :animals AND p.isActive = true")
	List<Post> findAnimalsPosts(@Param("animals") List<Animal> animals);
}
