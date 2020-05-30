package ru.itis.foodbook_app.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@Aspect
@Slf4j
public class LoggerService {
    @Before(value = "execution(* ru.itis.foodbook_app.service.SignUpServiceImpl.signUp(..))")
    public void logSignUp(JoinPoint joinPoint) {
        System.out.println("Registration attempt");
    }

    @Before(value = "execution(* ru.itis.foodbook_app.service.ConfirmServiceImpl.confirm(..))")
    public void logConfirm(JoinPoint joinPoint) {
        System.out.println("Confirm attempt");
    }

    @After(value = "execution(* ru.itis.foodbook_app.service.NewRecipeService.addRecipe(..))")
    public void logNewRecipe(JoinPoint joinPoint) {
        System.out.println("New recipe attempt");
    }

    @Before(value = "execution(* ru.itis.foodbook_app.service.*.*(*))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Метод вызывается");
        Date date = new Date();
        System.out.println("Время: " + date);
        System.out.println("Сигнатура метода: " + joinPoint.getSignature());
        System.out.print("Аргументы метода: ");
        for (Object arguments : joinPoint.getArgs()) {
            System.out.print(arguments + "\t");
        }
        System.out.println("\n");
    }
}
