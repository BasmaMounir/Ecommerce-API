package com.example.E_commerce.controller;

import com.example.E_commerce.dto.CategoryDto;
import com.example.E_commerce.model.Category;
import com.example.E_commerce.response.ApiResponse;
import com.example.E_commerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addCategory(@RequestBody CategoryDto categoryDto) {
        Category category = categoryService.addCategory(categoryDto);
        return ResponseEntity.ok(new ApiResponse("Success", category));
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllCategory() {
        List<Category> categories = categoryService.getAllCategory();
        return ResponseEntity.ok(new ApiResponse("Success", categories));
    }
}
