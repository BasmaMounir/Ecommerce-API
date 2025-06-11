package com.example.E_commerce.controller;

import com.example.E_commerce.model.Cart;

import com.example.E_commerce.response.ApiResponse;
import com.example.E_commerce.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("/addProduct/{id}")
    public ResponseEntity<ApiResponse> addProductToCart(@PathVariable int id){
        Cart cart = cartService.addProductToCart(id);
        return ResponseEntity.ok(new ApiResponse("Success", cart));
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getCart() {
        Cart cart = cartService.getCart();
        return ResponseEntity.ok(new ApiResponse("Success", cart));
    }
}
