package com.example.E_commerce.service;

import com.example.E_commerce.dto.UserDto;
import com.example.E_commerce.exception.ResourceNotFoundException;
import com.example.E_commerce.model.Role;
import com.example.E_commerce.model.User;
import com.example.E_commerce.repository.UserRepository;
import com.example.E_commerce.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UserDto register(UserDto userDto){
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        if (userDto.getRole() != null) {
            user.setRole(Role.valueOf(userDto.getRole()));
        } else {
            user.setRole(Role.USER);
        }
        userRepository.save(user);
        return userDto;
    }

    public String login(UserDto userDto){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getUsername(),userDto.getPassword()));
        User user = userRepository.findByUsername(userDto.getUsername()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return jwtService.generateToken(user);
    }
}
