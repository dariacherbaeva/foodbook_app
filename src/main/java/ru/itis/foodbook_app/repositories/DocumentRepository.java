package ru.itis.foodbook_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.foodbook_app.models.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
