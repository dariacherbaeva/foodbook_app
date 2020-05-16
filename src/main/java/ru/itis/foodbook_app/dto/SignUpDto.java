package ru.itis.foodbook_app.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class SignUpDto {
    private String username;
    private String name;

    @Email(message = "{errors.incorrect.email}")
    private String email;

    private String password;

    @NotNull(message = "{errors.null.age}")
    @Min(value = 14, message = "{errors.min.age}")
    @Max(value=150, message = "{errors.max.age}")
    private int age;

    private Long phone;
}

