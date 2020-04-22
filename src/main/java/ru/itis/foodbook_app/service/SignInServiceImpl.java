package ru.itis.foodbook_app.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.foodbook_app.dto.SignInDto;
import ru.itis.foodbook_app.dto.TokenDto;
import ru.itis.foodbook_app.models.User;
import ru.itis.foodbook_app.repositories.UsersRepository;


import java.util.Optional;

@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public TokenDto signIn(SignInDto signInData) {
        // получаем пользователя по его email
        Optional<User> userOptional = usersRepository.findByEmail(signInData.getUsername());
        // если у меня есть этот пользвователь
        if (userOptional.isPresent()) {
            // получаем его
            User user = userOptional.get();
            // если пароль подходит
            if (passwordEncoder.matches(signInData.getPassword(), user.getHashPassword())) {
                // создаем токен
                String token = Jwts.builder()
                        .setSubject(user.getId().toString()) // id пользователя
                        .claim("name", user.getName()) // имя
                        .claim("role", user.getRole().name()) // роль
                        .signWith(SignatureAlgorithm.HS256, secret) // подписываем его с нашим secret
                        .compact(); // преобразовали в строку
                return new TokenDto(token);
            } else throw new AccessDeniedException("Wrong email/password");
        } else throw new AccessDeniedException("User not found");
    }
}

