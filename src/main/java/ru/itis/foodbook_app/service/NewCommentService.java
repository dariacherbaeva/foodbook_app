package ru.itis.foodbook_app.service;

import org.springframework.stereotype.Service;
import ru.itis.foodbook_app.dto.CommentDto;

@Service
public interface NewCommentService {
    void addComment(CommentDto form, Long id);
}
