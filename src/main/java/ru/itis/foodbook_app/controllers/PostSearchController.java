package ru.itis.foodbook_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itis.foodbook_app.dto.PostSearchResult;
import ru.itis.foodbook_app.service.PostSearchService;

@Controller
public class PostSearchController {

    @Autowired
    private PostSearchService searchService;


    @GetMapping("/search")
    public String searchResult(@ModelAttribute("model") ModelMap model,
                                    @RequestParam("q") String query,
                                    @RequestParam("page") Integer page,
                                    @RequestParam("size") Integer size) {
         model.addAttribute("recipes", searchService.searchPosts(query, page, size).getPosts());
         return "list";
    }


}
