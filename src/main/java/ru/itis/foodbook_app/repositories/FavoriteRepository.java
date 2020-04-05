package ru.itis.foodbook_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.foodbook_app.models.Favorite;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    List<Favorite> findByUserId(Long id);
    Favorite findByUserIdAndAndRecipeId(Long userId, Long recipeId);
}
