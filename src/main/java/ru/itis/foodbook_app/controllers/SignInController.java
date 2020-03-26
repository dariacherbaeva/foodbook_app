package ru.itis.foodbook_app.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {
    @GetMapping("/login")
    public String getSignIn(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/profile";
        }
        return "login";
    }
}
