package com.example.E_commerce.controller;

import com.example.E_commerce.dto.ProductDto;
import com.example.E_commerce.model.Product;
import com.example.E_commerce.response.ApiResponse;
import com.example.E_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDto productDto){
        Product product = productService.addProduct(productDto);
        return ResponseEntity.ok(new ApiResponse("Success",product));
    }


    @GetMapping
    public ResponseEntity<ApiResponse> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(new ApiResponse("Success",products));

    }


}
