package ru.itis.foodbook_app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.foodbook_app.dto.SignUpDto;
import ru.itis.foodbook_app.models.Role;
import ru.itis.foodbook_app.models.State;
import ru.itis.foodbook_app.models.User;
import ru.itis.foodbook_app.repositories.UsersRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ExecutorService executorService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private SmsService smsService;

    @Override
    public void signUp(SignUpDto form) {
        User user = User.builder()
                .username(form.getUsername())
                .email(form.getEmail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .name(form.getName())
                .state(State.NOT_CONFIRMED)
                .phone(form.getPhone())
                .role(Role.USER)
                .createdAt(LocalDateTime.now())
                .confirmCode(UUID.randomUUID().toString())
                .age(form.getAge())
                .build();

        usersRepository.save(user);

        executorService.submit(() -> {
            emailService.sendMail("Регистрация", "Добрый день, " + user.getName()
                    + "! " + "Для подтверждения вашего аккаунта пройдите по ссылке " + "http://localhost:8080/confirm/" + user.getConfirmCode(), user.getEmail());
        });

        smsService.send(form);

    }
}


