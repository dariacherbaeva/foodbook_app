package ru.itis.foodbook_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.foodbook_app.dto.UserDto;
import ru.itis.foodbook_app.models.Recipe;
import ru.itis.foodbook_app.repositories.RecipesRepository;
import ru.itis.foodbook_app.service.ProfileService;


import java.util.List;
import java.util.Map;

@Controller
public class RecipeListController {

    @Autowired
    private RecipesRepository recipesRepository;

    @Autowired
    ProfileService profileService;

    @GetMapping("/feed")
    public String getRecipesList(@ModelAttribute("model") ModelMap model, Authentication authentication) {
        List<Recipe> recipes = recipesRepository.findAll();
        if (authentication != null) {
            UserDto user = profileService.getCurrentUser().get();
            model.addAttribute("user", user);
        }
        model.addAttribute("recipes", recipes);
        return "list";
    }


}
