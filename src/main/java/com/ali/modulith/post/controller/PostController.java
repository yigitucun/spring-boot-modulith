package com.ali.modulith.post.controller;

import com.ali.modulith.post.business.abstracts.PostService;
import com.ali.modulith.post.dto.requests.AddPostRequest;
import com.ali.modulith.post.dto.requests.UpdatePostRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/posts")
@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PutMapping
    private ResponseEntity<?> update(@Valid @RequestBody UpdatePostRequest request){
        return new ResponseEntity<>(this.postService.update(request),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return ResponseEntity.ok(this.postService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        this.postService.delete(id);
        return ResponseEntity.ok("Başarıyla silindi");
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.postService.getAll());
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody AddPostRequest request){
        return new ResponseEntity<>(this.postService.add(request), HttpStatus.CREATED);
    }

}
