package com.example.E_commerce.service;

import com.example.E_commerce.dto.CategoryDto;
import com.example.E_commerce.model.Category;
import com.example.E_commerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(CategoryDto categoryDto){
        categoryDto.setProductDtoList(new ArrayList<>());
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setProducts(categoryDto.getProductDtoList());
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
}
