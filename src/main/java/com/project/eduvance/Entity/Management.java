package com.project.eduvance.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
    @Lob
    private String unPhoto;
    private LocalDate dateCreated;

    private String csId;

    private String unId;

}
