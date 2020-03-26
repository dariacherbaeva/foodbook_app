package ru.itis.foodbook_app.service;

public interface EmailService {
    void sendMail(String subject, String text, String email);
}