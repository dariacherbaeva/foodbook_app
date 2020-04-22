package ru.itis.foodbook_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.itis.foodbook_app.dto.SignInDto;
import ru.itis.foodbook_app.dto.TokenDto;
import ru.itis.foodbook_app.service.SignInService;

@Controller
public class SignInController {

    @Autowired
    private SignInService signInService;

    @GetMapping("/login")
    public String getSignIn(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/profile";
        }
        return "login";
    }

    @PostMapping("/signIn")
    public ResponseEntity<TokenDto> signIn(@RequestBody SignInDto signInData) {
        return ResponseEntity.ok(signInService.signIn(signInData));
    }

}
