package ru.itis.foodbook_app.service;

import org.springframework.security.core.Authentication;
import ru.itis.foodbook_app.dto.UserDto;

import java.util.Optional;


public interface ProfileService {
    Optional<UserDto> getCurrentUser();
}
