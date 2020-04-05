package ru.itis.foodbook_app.service;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import ru.itis.foodbook_app.dto.RecipeDto;
import ru.itis.foodbook_app.models.User;

@Service
public interface NewRecipeService {
    void addRecipe(RecipeDto form, @AuthenticationPrincipal User user);
}
