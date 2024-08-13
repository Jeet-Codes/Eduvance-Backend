package com.project.eduvance.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Management {
    @Id
    private String mtId;
    private String mtName;
    private String mtEmail;
    private String mtPasswd;
    private String mtPhone;
    private String mtGender;
    private String mtBloodGrup;
    private String mtPhoto;
    private LocalDate dateCreated;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campus_id")
    @JsonIgnore
    private Campus campus;


}
