package ru.itis.foodbook_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.foodbook_app.dto.RecipeDto;
import ru.itis.foodbook_app.models.User;
import ru.itis.foodbook_app.service.NewRecipeService;

@Controller
public class NewRecipeController {

    @Autowired
    NewRecipeService newRecipeService;

    @PostMapping("/new")
    public String addRecipe(RecipeDto form, @AuthenticationPrincipal User user) {
            newRecipeService.addRecipe(form, user);
        return "new_post";
    }
}
