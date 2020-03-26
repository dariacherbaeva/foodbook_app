package ru.itis.foodbook_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.foodbook_app.models.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}
