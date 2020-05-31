package ru.itis.foodbook_app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Slf4j
@Table(name = "foodbook_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String username;
    protected String email;
    private String hashPassword;
    private LocalDateTime createdAt;
    protected String name;
    protected int age;
    private Long phone;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    private String confirmCode;


    @OneToMany(mappedBy = "owner")
    @Where(clause = "type = 'image/png'")
    private List<Document> pngDocuments;

    @OneToMany(mappedBy = "owner")
    private List<Document> documents;


}
