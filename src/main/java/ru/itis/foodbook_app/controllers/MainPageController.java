package ru.itis.foodbook_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.itis.foodbook_app.dto.RecipeDto;
import ru.itis.foodbook_app.service.RecipeService;

import java.util.List;

@Controller
public class MainPageController {

    @Autowired
    RecipeService recipeService;

    @GetMapping("/")
    public String getRootPage(Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        } else {
            return "redirect:/feed";
        }
    }
}
