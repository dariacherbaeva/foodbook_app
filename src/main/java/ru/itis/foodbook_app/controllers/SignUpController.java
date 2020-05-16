package ru.itis.foodbook_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.foodbook_app.dto.SignUpDto;
import ru.itis.foodbook_app.service.SignUpService;

import javax.validation.Valid;


@Controller
public class SignUpController {

    @Autowired
    private SignUpService service;


    @GetMapping("/sign_up")
    public String getSignUpPage(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/profile";
        }
        return "sign_up";
    }

    @PostMapping("/sign_up")
    public String signUp(@Valid SignUpDto form, BindingResult bindingResult) {
        service.signUp(form);
        System.out.println(bindingResult.getAllErrors());
        return "/login";
    }
}
