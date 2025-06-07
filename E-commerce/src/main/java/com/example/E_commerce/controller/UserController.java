package com.example.E_commerce.controller;

import com.example.E_commerce.dto.UserDto;
import com.example.E_commerce.model.Role;
import com.example.E_commerce.model.User;
import com.example.E_commerce.repository.UserRepository;
import com.example.E_commerce.response.ApiResponse;
import com.example.E_commerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody UserDto userDto) {
        try {
            userService.register(userDto);
            return ResponseEntity.ok(new ApiResponse("User registered successfully!", userDto.getUsername()));
        } catch (DataIntegrityViolationException ex) {
            if (ex.getCause() instanceof ConstraintViolationException ||
                    ex.getMessage().contains("Duplicate entry")) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(new ApiResponse("Username '" + userDto.getUsername() + "' already exists!", null));
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("Registration failed due to server error", null));
        }
    }


    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody UserDto userDto) {
        String token = userService.login(userDto);
        return ResponseEntity.ok(new ApiResponse("Login Success",token));
    }

}
