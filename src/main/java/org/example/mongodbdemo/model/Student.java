package org.example.mongodbdemo.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Document
public class Student {
    @Id
    String id;
    String firstName;
    String lastName;
    @Indexed(unique = true)
    String email;
    Gender gender;
    Address address;
    List<String> favoriteSubjects;
    BigDecimal totalSpentInBooks;
    LocalDateTime created;

    public Student(String firstName,
                   String lastName,
                   String email,
                   Gender gender,
                   Address address,
                   List<String> favoriteSubjects,
                   BigDecimal totalSpentInBooks,
                   LocalDateTime created)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.favoriteSubjects = favoriteSubjects;
        this.totalSpentInBooks = totalSpentInBooks;
        this.created = created;
    }
}
