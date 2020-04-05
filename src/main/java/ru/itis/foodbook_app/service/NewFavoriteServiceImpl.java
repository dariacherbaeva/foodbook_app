package ru.itis.foodbook_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.itis.foodbook_app.dto.FavoriteDto;
import ru.itis.foodbook_app.models.Favorite;
import ru.itis.foodbook_app.repositories.FavoriteRepository;
import ru.itis.foodbook_app.repositories.UsersRepository;

@Service
public class NewFavoriteServiceImpl implements NewFavoriteService{

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    FavoriteRepository favoriteRepository;

    @Override
    public void addFavorite(FavoriteDto form, Long id) {
        if (favoriteRepository.findByUserIdAndAndRecipeId(usersRepository.findByEmail
                (((UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal()).getUsername()).get().getId(), id) == null) {
            Favorite favorite = Favorite.builder()
                    .recipeId(id)
                    .userId(usersRepository.findByEmail(((UserDetails) SecurityContextHolder.getContext()
                            .getAuthentication().getPrincipal()).getUsername()).get().getId())
                    .build();

            favoriteRepository.save(favorite);
        }
    }
}
