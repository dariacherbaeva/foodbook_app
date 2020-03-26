package ru.itis.foodbook_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.foodbook_app.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
