package ru.itis.foodbook_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.foodbook_app.dto.CommentDto;
import ru.itis.foodbook_app.models.Comment;
import ru.itis.foodbook_app.service.NewCommentService;

@Controller
public class NewCommentController {

    @Autowired
    NewCommentService newCommentService;

    @GetMapping("/new_comment")
    public String getCommentForm(Authentication authentication, @ModelAttribute("model") ModelMap model) {
        if (authentication == null) {
            return "redirect:/login";
        } else
            return "new_comment";
    }

    @PostMapping("/new_comment")
    public String addComment(CommentDto form, @RequestParam Long id){
        newCommentService.addComment(form, id);
        return "redirect:/post?=" + id;
    }
}
