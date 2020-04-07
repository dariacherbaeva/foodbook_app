package ru.itis.foodbook_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.foodbook_app.service.RecipeService;
import ru.itis.foodbook_app.service.RecipeServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

@SpringBootApplication
public class FoodbookAppApplication {

    // @Bean
    //public JavaMailSender mailSender() { return new JavaMailSenderImpl();
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ExecutorService executorService() {
        return Executors.newFixedThreadPool(20);
    }

    @Bean
    public RecipeService recipeService() {
        return new RecipeServiceImpl();
    }


    public static void main(String[] args) {
        SpringApplication.run(FoodbookAppApplication.class, args);
    }

}
