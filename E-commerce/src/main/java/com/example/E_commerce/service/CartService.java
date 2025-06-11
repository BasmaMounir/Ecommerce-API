package com.example.E_commerce.service;

import com.example.E_commerce.exception.ResourceNotFoundException;
import com.example.E_commerce.model.Cart;
import com.example.E_commerce.model.User;
import com.example.E_commerce.repository.CartRepository;
import com.example.E_commerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public Cart addProductToCart(int productId){
        User user = getCurrantUser();
        if(user.getCart() == null){
            Cart cart = new Cart();
            cart.setUser(user);
            cartRepository.save(cart);
            user.setCart(cart);
        }
        Cart cart = user.getCart();
        cart.getProducts().add(productRepository.findById(productId).orElseThrow(
                ()->   new ResourceNotFoundException("Product not found")
        ));
        return cartRepository.save(cart);
    }

    public Cart getCart() {
        User user = getCurrantUser();
        if (user.getCart() == null) {
            Cart cart = new Cart();
            cart.setUser(user);
            cartRepository.save(cart);
            user.setCart(cart);
        }
        return user.getCart();
    }
    public User getCurrantUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
