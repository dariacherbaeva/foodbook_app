package ru.itis.foodbook_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.foodbook_app.dto.RecipeDto;
import ru.itis.foodbook_app.models.Recipe;
import ru.itis.foodbook_app.repositories.RecipesRepository;

import java.util.List;
import java.util.Optional;

public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipesRepository recipesRepository;

    @Override
    public List<RecipeDto> getAllRecipes() {
        List<Recipe> recipes = recipesRepository.findAll();
        return RecipeDto.from(recipes);
    }

    @Override
    public Optional<RecipeDto> getRecipe(Long id) {
        return recipesRepository.findById(id).map(recipe -> RecipeDto.builder()
                .name(recipe.getName())
                .text(recipe.getText())
                .photoPath(recipe.getPhoto().getStorageFileName())
                .build());

    }
}
