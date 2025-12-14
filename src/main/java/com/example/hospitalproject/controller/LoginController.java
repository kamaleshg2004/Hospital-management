package com.example.hospitalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    // Show login form
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // maps to login.html
    }

    // Redirect to dashboard after successful login (Spring Security handles auth)
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // maps to dashboard.html
    }
}
