package ru.itis.foodbook_app.schedulers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.foodbook_app.dto.RecipeDto;
import ru.itis.foodbook_app.service.NewRecipeService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@EnableScheduling
@Slf4j
public class FoodBookSchedulers {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private NewRecipeService newRecipeService;

    @Scheduled(cron = "0 1 1 * * ?")
    public void reportCurrentTime() {
        newRecipeService.addRecipe(RecipeDto.builder().
                name("Today is" + dateFormat.format(new Date())).
                text("Today is "+ dateFormat.format(new Date()) + "\n" + "Wish you a good day!").
                build());
    }

}

