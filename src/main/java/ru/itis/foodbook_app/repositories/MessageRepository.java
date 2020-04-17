package ru.itis.foodbook_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.foodbook_app.models.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> getAllBySenderEmail(String email);

    List<Message> getAllByReceiverEmail(String email);

    List<Message> getAllBySenderEmailAndReceiverEmail(String senderEmail, String receiverEmail);
}