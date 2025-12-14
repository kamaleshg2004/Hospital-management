package com.example.hospitalproject.controller;

import com.example.hospitalproject.model.User;
import com.example.hospitalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    // Show registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";  // your register.html template
    }

    // Handle registration form submission for regular users
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        try {
            userService.registerUser(user);
            model.addAttribute("message", "Registration successful! Please login.");
            return "login";  // redirect to login page after successful registration
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred during registration.");
            return "register";
        }
    }

    // (Optional) Separate admin registration if needed
    @PostMapping("/registerAdmin")
    public String registerAdmin(@ModelAttribute("user") User user, Model model) {
        try {
        	userService.registerUser(user);

            model.addAttribute("message", "Admin registration successful!");
            return "login";
        } catch (Exception e) {
            model.addAttribute("error", "Error registering admin.");
            return "register";
        }
    }
}
