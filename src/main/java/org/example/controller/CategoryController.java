package org.example.controller;

import org.example.dto.CategoryRequestDTO;
import org.example.entity.Category;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<String> addCategory(@RequestBody CategoryRequestDTO categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());

        return ResponseEntity.status(HttpStatus.CREATED).body("Category successfully created");
    }
}
