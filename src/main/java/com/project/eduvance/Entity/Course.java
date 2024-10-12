package com.project.eduvance.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "degree_id")
    @JsonIgnore
    private Degree degree;

}
