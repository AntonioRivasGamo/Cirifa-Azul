package com.cirifa_azul.adoption.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cirifa_azul.adoption.domain.entities.Animal;
import com.cirifa_azul.adoption.domain.entities.Post;

public interface PostService {

	Optional<Post> findPostById(UUID id);
	Post createPost(Post post);
	Boolean deletePost(UUID id);
	Post updatePost(Post post);
	List<Post> findAnimalsPosts(List<Animal> list);
}
