package ru.itis.foodbook_app.service;

import ru.itis.foodbook_app.dto.MessageDto;

import java.util.List;

public interface MessageService {
    void save(MessageDto dto);

    List<MessageDto> getDialog(String firstLogin, String secondLogin);
}