package ru.itis.foodbook_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.foodbook_app.dto.RecipeDto;
import ru.itis.foodbook_app.models.FileInfo;
import ru.itis.foodbook_app.models.User;
import ru.itis.foodbook_app.service.FileStorageService;
import ru.itis.foodbook_app.service.NewRecipeService;

@Controller
public class NewRecipeController {

    @Autowired
    NewRecipeService newRecipeService;

    @Autowired
    FileStorageService fileStorageService;

    @GetMapping("/new")
    public String getRecipeForm(Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        } else return "new_post";
    }

    @PostMapping("/new")
    public String addRecipe(RecipeDto form) {
        newRecipeService.addRecipe(form);
        return "redirect:/feed";
    }
}
