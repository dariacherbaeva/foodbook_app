package ru.itis.foodbook_app.service;


import ru.itis.foodbook_app.dto.PostSearchResult;

public interface PostSearchService {
    PostSearchResult searchPosts(String query, Integer page, Integer size);
}

