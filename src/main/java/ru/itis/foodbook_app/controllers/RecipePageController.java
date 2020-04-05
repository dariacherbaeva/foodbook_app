package ru.itis.foodbook_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.foodbook_app.dto.UserDto;
import ru.itis.foodbook_app.repositories.CommentRepository;
import ru.itis.foodbook_app.repositories.RecipesRepository;
import ru.itis.foodbook_app.service.ProfileService;
import ru.itis.foodbook_app.service.RecipeService;

@Controller
public class RecipePageController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RecipesRepository recipesRepository;

    @GetMapping("/post")
    public String getPostPage(@ModelAttribute("model") ModelMap model,
                              @RequestParam(value = "id") Long id) {
        if (id != null & recipeService.getRecipe(id).isPresent()) {
            model.addAttribute("recipe", recipesRepository.findById(id).get());
            model.addAttribute("message", "No comments yet.");
            model.addAttribute("comments", commentRepository.findByRecipeId(id));
        } else {
            model.addAttribute("message", "No such post!");
        }
    return "post";
    }

}
