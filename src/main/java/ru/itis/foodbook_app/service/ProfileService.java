package ru.itis.foodbook_app.service;

import org.springframework.security.core.Authentication;
import ru.itis.foodbook_app.dto.UserDto;


public interface ProfileService {
    UserDto getUserInformation(Authentication authentication);
}
