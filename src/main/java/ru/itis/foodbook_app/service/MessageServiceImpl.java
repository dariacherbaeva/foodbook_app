package ru.itis.foodbook_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.foodbook_app.dto.MessageDto;
import ru.itis.foodbook_app.models.Message;
import ru.itis.foodbook_app.models.User;
import ru.itis.foodbook_app.repositories.MessageRepository;
import ru.itis.foodbook_app.repositories.UsersRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MessageServiceImpl implements MessageService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void save(MessageDto dto) {

        Optional<User> userFirst = usersRepository.findByEmail(dto.getSender());
        Optional<User> userSecond = usersRepository.findByEmail(dto.getReceiver());

        if (userFirst.isPresent() && userSecond.isPresent()) {
            messageRepository.save(Message.builder()
                    .receiver(userSecond.get())
                    .sender(userFirst.get())
                    .text(dto.getText())
                    .build());
        }
    }

    @Override
    public List<MessageDto> getDialog(String firstEmail, String secondEmail) {
        List<Message> dialogRaw = messageRepository.getAllBySenderEmailAndReceiverEmail(firstEmail, secondEmail);
        dialogRaw.addAll(messageRepository.getAllBySenderEmailAndReceiverEmail(secondEmail, firstEmail));
        dialogRaw.sort(Comparator.comparingLong(Message::getId));
        return dialogRaw.stream().map(msg -> MessageDto.builder()
                .text(msg.getText())
                .sender(msg.getSender().getEmail())
                .receiver(msg.getReceiver().getEmail())
                .build())
                .collect(Collectors.toList());
    }
}
