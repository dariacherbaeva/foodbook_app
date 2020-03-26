package ru.itis.foodbook_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.foodbook_app.models.Recipe;

public interface RecipesRepository extends JpaRepository<Recipe, Long> {
}
