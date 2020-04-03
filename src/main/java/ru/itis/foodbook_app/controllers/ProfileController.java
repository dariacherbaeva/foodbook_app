package ru.itis.foodbook_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.itis.foodbook_app.dto.UserDto;
import ru.itis.foodbook_app.service.ProfileService;

@Controller
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/profile")
    public String getProfilePage(@ModelAttribute("model") ModelMap model) {
        if (profileService.getCurrentUser().isPresent()) {
            model.addAttribute("user", profileService.getCurrentUser().get());
        }

        return "profile";
    }
}
