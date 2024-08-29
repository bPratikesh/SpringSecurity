package com.pratikesh.SecurityApp.SecurityApplication.service;

import com.pratikesh.SecurityApp.SecurityApplication.dto.PostDTO;

import java.util.List;

public interface PostService {
    public List<PostDTO> getAllPosts();
    public PostDTO createNewPost(PostDTO postDTO);
    public PostDTO getPostById(Long postId);
}
