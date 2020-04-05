package ru.itis.foodbook_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.foodbook_app.models.Comment;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {

    String text;

    public static CommentDto from(Comment comment) {
        return CommentDto.builder()
                .text(comment.getText())
                .build();
    }

    public static List<CommentDto> from(List<Comment> commentList) {
        return commentList.stream()
                .map(CommentDto::from)
                .collect(Collectors.toList());
    }
}
