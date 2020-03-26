package ru.itis.foodbook_app.service;

import ru.itis.foodbook_app.dto.SignUpDto;

import java.util.concurrent.Future;

public interface SmsService {
    Future<Boolean> send(SignUpDto form);
}
