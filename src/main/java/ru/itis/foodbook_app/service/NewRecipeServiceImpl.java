package ru.itis.foodbook_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.foodbook_app.dto.RecipeDto;
import ru.itis.foodbook_app.models.FileInfo;
import ru.itis.foodbook_app.models.Recipe;
import ru.itis.foodbook_app.models.User;
import ru.itis.foodbook_app.repositories.FileInfoRepository;
import ru.itis.foodbook_app.repositories.RecipesRepository;
import ru.itis.foodbook_app.repositories.UsersRepository;
import ru.itis.foodbook_app.utils.FileStorageUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

@Service
public class NewRecipeServiceImpl implements NewRecipeService {

    HttpServletRequest request;

    @Autowired
    ProfileService profileService;

    @Autowired
    RecipesRepository recipesRepository;

    @Autowired
    FileInfoRepository fileInfoRepository;

    @Autowired
    FileStorageService fileStorageService;

    @Autowired
    FileStorageUtil fileStorageUtil;

    @Autowired
    UsersRepository usersRepository;

    @Override
    public void addRecipe(RecipeDto form, @AuthenticationPrincipal User user) {
        if (profileService.getCurrentUser().isPresent()) {

            FileInfo picFile = FileInfo.builder()
                    .originalFileName(form.getPhotoPath())
                    .storageFileName(form.getPhotoPath())
                    .url(fileStorageUtil.getStoragePath())
                    .size(fileStorageUtil.sizeOf(fileStorageUtil.getStoragePath()))
                    .type("image/jpg")
                    .build();

            fileInfoRepository.save(picFile);
            Recipe recipe = Recipe.builder()
                    .name(form.getName())
                    .text(form.getText())
                    .photo(picFile)
                    .authorId(usersRepository.findByEmail(((UserDetails) SecurityContextHolder.getContext()
                            .getAuthentication().getPrincipal()).getUsername()).get().getId())
                    .createdAt(new Timestamp(System.currentTimeMillis()))
                    .build();

            recipesRepository.save(recipe);
        }
    }


}
