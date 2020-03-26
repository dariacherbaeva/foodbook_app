package ru.itis.foodbook_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.foodbook_app.models.Recipe;
import ru.itis.foodbook_app.repositories.RecipesRepository;

import java.util.List;
import java.util.Map;

@Controller
public class RecipeListController {

    @Autowired
    private RecipesRepository recipesRepository;

    @GetMapping("/")
    public String getRecipesList(Map<String, Object> model) {
        List<Recipe> recipes = recipesRepository.findAll();

        model.put("recipes", recipes);

        return "list";
    }

    @PostMapping("/new")
    public String addRecipe (@RequestParam String name, @RequestParam String text, Map<String, Object> model) {
        return "new_post";
    }

}
