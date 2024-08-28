package com.project.eduvance.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @Column(name = "ceId")
    private String id;

    @Column(name = "ceName")
    private String name;

    @Column(name = "ceCode")
    private String code;

    @Column(name = "ceAuthor")
    private String author;

    @Column(name = "ceDesc")
    private String description;

    @Column(name = "ceCredit")
    private Integer credit;
}
