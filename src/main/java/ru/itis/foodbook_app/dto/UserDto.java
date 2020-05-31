package ru.itis.foodbook_app.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import ru.itis.foodbook_app.models.Document;
import ru.itis.foodbook_app.models.User;

import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    protected Long id;

    protected String username;
    protected String email;
    private LocalDateTime createdAt;
    protected String name;
    protected int age;
    private Long phone;

    @OneToMany(mappedBy = "owner")
    @Where(clause = "type = 'image/png'")
    private List<Document> pngDocuments;

    @OneToMany(mappedBy = "owner")
    private List<Document> documents;


    public static UserDto from(User user) {
        return UserDto.builder()
                .email(user.getEmail())
                .name(user.getName())
                .id(user.getId())
                .age(user.getAge())
                .createdAt(user.getCreatedAt())
                .build();
    }

    public static List<UserDto> from(List<User> users) {
        return users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }


}
