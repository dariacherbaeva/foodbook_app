package ru.itis.foodbook_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.itis.foodbook_app.dto.UserDto;
import ru.itis.foodbook_app.models.Role;
import ru.itis.foodbook_app.models.User;
import ru.itis.foodbook_app.repositories.UsersRepository;

import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Optional<UserDto> getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return usersRepository.findByEmail(((UserDetails) principal).getUsername()).map(user -> UserDto.builder()
                .email(user.getEmail())
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .age(user.getAge())
                .phone(user.getPhone())
                .build());

    }

    @Override
    public Optional<UserDto> getAdmin() {
        return usersRepository.findByRole(Role.ADMIN).map(user -> UserDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .age(user.getAge())
                .name(user.getName())
                .username(user.getUsername())
                .phone(user.getPhone())
                .createdAt(user.getCreatedAt())
                .build());

    }
}
