package ru.itis.foodbook_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import ru.itis.foodbook_app.dto.PostSearchResult;
import ru.itis.foodbook_app.models.Recipe;
import ru.itis.foodbook_app.repositories.RecipesRepository;

import java.awt.print.Pageable;

public class PostSearchServiceImpl implements PostSearchService {

    @Autowired
    RecipesRepository recipesRepository;

    @Override
    public PostSearchResult searchPosts(String query, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Recipe> pageResult = recipesRepository.search(query, pageRequest);
        return PostSearchResult.builder()
                .pagesCount(pageResult.getTotalPages())
                .posts(pageResult.getContent())
                .build();

    }
}
