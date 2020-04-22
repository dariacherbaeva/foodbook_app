package ru.itis.foodbook_app.service;

import ru.itis.foodbook_app.dto.SignInDto;
import ru.itis.foodbook_app.dto.TokenDto;

public interface SignInService {
    TokenDto signIn(SignInDto signInData);
}
