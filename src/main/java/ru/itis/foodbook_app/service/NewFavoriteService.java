package ru.itis.foodbook_app.service;

import org.springframework.stereotype.Service;
import ru.itis.foodbook_app.dto.FavoriteDto;

@Service
public interface NewFavoriteService {
    void addFavorite(FavoriteDto form, Long id);
}
