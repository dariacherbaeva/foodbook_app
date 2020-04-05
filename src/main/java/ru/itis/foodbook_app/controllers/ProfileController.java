package ru.itis.foodbook_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.foodbook_app.dto.UserDto;
import ru.itis.foodbook_app.models.User;
import ru.itis.foodbook_app.repositories.FavoriteRepository;
import ru.itis.foodbook_app.repositories.RecipesRepository;
import ru.itis.foodbook_app.repositories.UsersRepository;
import ru.itis.foodbook_app.service.ProfileService;

@Controller
public class ProfileController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private RecipesRepository recipesRepository;

    @Autowired
    private FavoriteRepository favoriteRepository;

    @GetMapping("/profile")
    public String getProfilePage(@ModelAttribute("model") ModelMap model,
                                 @RequestParam(value = "id", required = false) Long id) {
        if ((id == null | id == profileService.getCurrentUser().get().getId())
                & profileService.getCurrentUser().isPresent()) {
            UserDto user = profileService.getCurrentUser().get();
            model.addAttribute("user", user);
            model.addAttribute("recipes", recipesRepository.findByAuthorId(user.getId()));
            model.addAttribute("favorites", favoriteRepository.findByUserId(user.getId()));
            model.addAttribute("is_my_profile", true);

            return "profile";
        }
        else if (id != null & usersRepository.findById(id).isPresent()){
            model.addAttribute("user", usersRepository.findById(id).get());
            model.addAttribute("recipes", recipesRepository.findByAuthorId(id));
            model.addAttribute("favorites", favoriteRepository.findByUserId(id));
            model.addAttribute("is_my_profile", false);
            return "not_my_profile";
        }
        return "profile";
    }
}
