package ru.itis.foodbook_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;
import ru.itis.foodbook_app.handlers.WebSocketHandler;
import ru.itis.foodbook_app.service.PostSearchService;
import ru.itis.foodbook_app.service.PostSearchServiceImpl;
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

    @Bean
    public PostSearchService postSearchService() {
        return new PostSearchServiceImpl();
    }

    @Bean
    public TaskScheduler taskScheduler() {
        return new ConcurrentTaskScheduler();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(FoodbookAppApplication.class, args);
    }

}
