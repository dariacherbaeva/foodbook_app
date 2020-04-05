package ru.itis.foodbook_app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "foodbook_recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String name;
    protected String text;
    protected Timestamp createdAt;
    protected Long authorId;

    @ManyToOne
    @JoinColumn(name = "file_info_id")
    private FileInfo photo;

}
