package ru.itis.foodbook_app.service;


import ru.itis.foodbook_app.dto.InformationDto;

public interface FilesService {
    void init();

    void convert();

    void convertPngByUser(Long userId);

    InformationDto getInformation(Long userId);
}

