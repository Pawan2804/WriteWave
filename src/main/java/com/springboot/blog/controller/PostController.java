package com.springboot.blog.controller;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping
    public ResponseEntity<PostDto>  createPost(@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }
    @GetMapping()
    public List<PostDto> getAllPosts(@RequestParam(value = "pageNo",defaultValue = "0",required = false) int pageNo,
                                     @RequestParam(value = "pageSize",defaultValue = "6",required = false) int pageSize){
        return postService.getAllPosts(pageNo,pageSize);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostsById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable(name = "id") Long id, @RequestBody PostDto postDto){
        PostDto postResponse =postService.updatePost(postDto,id);
        return new ResponseEntity<>(postResponse,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") Long id){
        postService.deletePost(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }

}
