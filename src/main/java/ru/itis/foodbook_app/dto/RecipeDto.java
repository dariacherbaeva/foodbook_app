package ru.itis.foodbook_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.foodbook_app.models.FileInfo;
import ru.itis.foodbook_app.models.Recipe;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeDto {

    protected String name;
    protected String text;

    public static RecipeDto from(Recipe recipe) {
        return RecipeDto.builder()
                .name(recipe.getName())
                .text(recipe.getText())
                .build();
    }

    public static List<RecipeDto> from(List<Recipe> recipeList) {
        return recipeList.stream()
                .map(RecipeDto::from)
                .collect(Collectors.toList());
    }

}
