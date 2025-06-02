package com.example.E_commerce.service;

import com.example.E_commerce.dto.ProductDto;
import com.example.E_commerce.exception.ResourceNotFoundException;
import com.example.E_commerce.model.Category;
import com.example.E_commerce.model.Product;
import com.example.E_commerce.repository.CategoryRepository;
import com.example.E_commerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product addProduct(ProductDto productDto){
        Category category = categoryRepository.findByName(productDto.getCategory_name()).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
      return  productRepository.findAll();
    }

}
