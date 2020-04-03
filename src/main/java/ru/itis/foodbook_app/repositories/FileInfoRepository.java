package ru.itis.foodbook_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.foodbook_app.models.FileInfo;


public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
    FileInfo findOneByStorageFileName(String storageFileName);
}
