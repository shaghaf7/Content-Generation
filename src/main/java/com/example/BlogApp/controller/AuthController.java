package com.example.BlogApp.controller;

import com.example.BlogApp.dto.LoginRequest;
import com.example.BlogApp.entity.User;
import com.example.BlogApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // SIGNUP → POST /api/auth/signup
    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // LOGIN → POST /api/auth/login
    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request) {
        return userService.login(request.getEmail(), request.getPassword());
    }
}
