package com.example.E_commerce.controller;

import com.example.E_commerce.dto.CategoryDto;
import com.example.E_commerce.model.Category;
import com.example.E_commerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category addCategory(@RequestBody CategoryDto categoryDto){return categoryService.addCategory(categoryDto);}

    @GetMapping
    public List<Category> getAllCategory(){return categoryService.getAllCategory();}
}
