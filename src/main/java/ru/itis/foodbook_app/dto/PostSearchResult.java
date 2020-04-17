package ru.itis.foodbook_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.foodbook_app.models.Recipe;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostSearchResult {
    private List<Recipe> posts;
    private int pagesCount;
}

