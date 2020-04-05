package ru.itis.foodbook_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.foodbook_app.models.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipesRepository extends JpaRepository<Recipe, Long> {
    Optional<Recipe> findById(Long id);
    List<Recipe> findByAuthorId(Long id);
}
