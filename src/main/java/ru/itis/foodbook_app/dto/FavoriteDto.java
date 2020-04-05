package ru.itis.foodbook_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.foodbook_app.models.Favorite;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FavoriteDto {

    protected Long userId;
    protected Long recipeId;

    public static FavoriteDto from(Favorite favorite) {
        return FavoriteDto.builder()
                .userId(favorite.getUserId())
                .recipeId(favorite.getRecipeId())
                .build();
    }

    public static List<FavoriteDto> from(List<Favorite> favoriteList) {
        return favoriteList.stream()
                .map(FavoriteDto::from)
                .collect(Collectors.toList());
    }
}
