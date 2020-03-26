package ru.itis.foodbook_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.foodbook_app.service.ConfirmService;

@Controller
public class ConfirmController {

    @Autowired
    private ConfirmService confirmService;

    @GetMapping("/confirm/{confirm-code}")
    public String getConfirm(@PathVariable("confirm-code") String confirmCode,
                             Model model) {
        boolean isConfirmed = confirmService.confirm(confirmCode);
        model.addAttribute("isConfirmed", isConfirmed);
        return "confirm_page";
    }
}
