package com.ali.modulith.category.controller;

import com.ali.modulith.category.business.abstracts.CategoryService;
import com.ali.modulith.category.dto.requests.AddCategoryRequest;
import com.ali.modulith.category.dto.requests.UpdateCategoryRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody AddCategoryRequest request){
        return new ResponseEntity<>(this.categoryService.add(request), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody UpdateCategoryRequest request){
        return new ResponseEntity<>(this.categoryService.update(request),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByCategory(@PathVariable int id){
        return ResponseEntity.ok(this.categoryService.getById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.categoryService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        this.categoryService.delete(id);
        return ResponseEntity.ok("Başarıyla silindi");
    }

}
