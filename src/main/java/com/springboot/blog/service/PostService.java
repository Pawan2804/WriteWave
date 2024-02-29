package com.springboot.blog.service;

import com.springboot.blog.payload.PostDto;

import java.util.List;

public interface PostService {
    public PostDto createPost(PostDto postDto);
    public List<PostDto> getAllPosts(int pageNo, int pageSize);
    public PostDto getPostById(Long id);
    public PostDto updatePost(PostDto postDto, Long id);
    public void deletePost(Long id);
}

