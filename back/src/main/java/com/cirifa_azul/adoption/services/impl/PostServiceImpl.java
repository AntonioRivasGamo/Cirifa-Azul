package com.cirifa_azul.adoption.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cirifa_azul.adoption.domain.entities.Animal;
import com.cirifa_azul.adoption.domain.entities.Post;
import com.cirifa_azul.adoption.repositories.PostRepository;
import com.cirifa_azul.adoption.services.PostService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
	
	private final PostRepository postRepository;

	@Override
	public Optional<Post> findPostById(UUID id) {
		return postRepository.findById(id);
	}

	@Override
	public Post createPost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public Boolean deletePost(UUID id) {
		if(postRepository.existsById(id)) {
			postRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Post updatePost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public List<Post> findAnimalsPosts(List<Animal> list) {
		return postRepository.findAnimalsPosts(list);
	}

	
}
