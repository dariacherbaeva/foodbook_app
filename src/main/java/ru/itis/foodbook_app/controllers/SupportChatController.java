package ru.itis.foodbook_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.foodbook_app.dto.UserDto;
import ru.itis.foodbook_app.models.Role;
import ru.itis.foodbook_app.models.State;
import ru.itis.foodbook_app.models.User;
import ru.itis.foodbook_app.repositories.UsersRepository;
import ru.itis.foodbook_app.service.MessageService;
import ru.itis.foodbook_app.service.ProfileService;

import java.util.Optional;

@Controller
public class SupportChatController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private UsersRepository usersRepository;


    @GetMapping("/support")
    public String getSupportPage(Model model, Authentication authentication) {

        if (authentication != null) {
            User user = usersRepository.findByUsername(profileService.getCurrentUser().get().getUsername());
            model.addAttribute("user", user);

            model.addAttribute("adminEmail", profileService.getAdmin().get().getEmail());

            if (user.getRole() == Role.ADMIN) {
                model.addAttribute("users", usersRepository.findAll());
            }

            model.addAttribute("messages", messageService.getDialog(user.getEmail(), profileService.getAdmin().get().getEmail()));
            return "support_chat";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/manage")
    public String getAdminPage(@RequestParam(value = "receiver") String receiver, Model model) {
        UserDto user = profileService.getCurrentUser().get();
        model.addAttribute("adminLogin", profileService.getAdmin().get().getEmail());
        model.addAttribute("user", user);
        model.addAttribute("users", usersRepository.findAll());
        model.addAttribute("messages", messageService.getDialog(user.getEmail(), receiver));
        return "support_chat";
    }
}
