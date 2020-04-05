package ru.itis.foodbook_app.service;

import ru.itis.foodbook_app.dto.RecipeDto;

import java.util.List;
import java.util.Optional;

public interface RecipeService {

    List<RecipeDto> getAllRecipes();
    Optional<RecipeDto> getRecipe(Long id);
}
