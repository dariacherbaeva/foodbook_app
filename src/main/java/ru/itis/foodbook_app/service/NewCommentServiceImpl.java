package ru.itis.foodbook_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.itis.foodbook_app.dto.CommentDto;
import ru.itis.foodbook_app.models.Comment;
import ru.itis.foodbook_app.repositories.CommentRepository;
import ru.itis.foodbook_app.repositories.UsersRepository;

@Service
public class NewCommentServiceImpl implements NewCommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UsersRepository usersRepository;

    @Override
    public void addComment(CommentDto form, Long id) {
        Comment comment = Comment.builder()
                .text(form.getText())
                .authorId(usersRepository.findByEmail(((UserDetails) SecurityContextHolder.getContext()
                        .getAuthentication().getPrincipal()).getUsername()).get().getId())
                .recipeId(id)
                .build();

        commentRepository.save(comment);
    }
}
