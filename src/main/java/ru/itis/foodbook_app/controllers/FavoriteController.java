package ru.itis.foodbook_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.foodbook_app.dto.FavoriteDto;
import ru.itis.foodbook_app.service.NewFavoriteService;

@Controller
public class FavoriteController {

    @Autowired
    NewFavoriteService newFavoriteService;

    @PostMapping("/favorite")
    public String addFavorite(Authentication authentication, FavoriteDto form, Long id) {
        newFavoriteService.addFavorite(form, id);
        return "profile";
    }
}
