package com.pratikesh.SecurityApp.SecurityApplication.service.Serviceimpl;

import com.pratikesh.SecurityApp.SecurityApplication.dto.PostDTO;
import com.pratikesh.SecurityApp.SecurityApplication.entities.PostEntity;
import com.pratikesh.SecurityApp.SecurityApplication.exceptions.ResourceNotFoundException;
import com.pratikesh.SecurityApp.SecurityApplication.repositories.PostRepository;
import com.pratikesh.SecurityApp.SecurityApplication.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO postDTO) {
        PostEntity postEntity = modelMapper.map(postDTO, PostEntity.class);
        PostEntity savedPostEntity = postRepository.save(postEntity);
        return modelMapper.map(savedPostEntity, PostDTO.class);
    }

    @Override
    public PostDTO getPostById(Long postId) {
        PostEntity postEntity = postRepository.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post not found with id: "+ postId));
        return modelMapper.map(postEntity, PostDTO.class);
    }
}
