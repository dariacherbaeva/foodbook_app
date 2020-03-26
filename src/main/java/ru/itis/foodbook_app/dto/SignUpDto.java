package ru.itis.foodbook_app.dto;

import lombok.Data;

@Data
public class SignUpDto {
    private String username;
    private String name;
    private String email;
    private String password;
    private int age;
    private Long phone;
}

