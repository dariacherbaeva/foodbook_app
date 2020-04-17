package ru.itis.foodbook_app.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.foodbook_app.models.Recipe;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface RecipesRepository extends JpaRepository<Recipe, Long> {
    Optional<Recipe> findById(Long id);

    List<Recipe> findByAuthorId(Long id);

    @Query("from Recipe recipe where " +
            "(upper(recipe.name) like concat('%', upper(:query), '%') or " +
            "upper(recipe.text) like concat('%', upper(:query), '%')) ")
    Page<Recipe> search(@Param("query") String query,
                        Pageable pageable);

}
