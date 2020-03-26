package ru.itis.foodbook_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itis.foodbook_app.dto.UserDto;
import ru.itis.foodbook_app.repositories.UsersRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDto getUserInformation(Authentication authentication) {
        return UserDto.from(usersRepository.findByEmail(authentication.getName())
                .orElseThrow(IllegalArgumentException::new));
    }
}
