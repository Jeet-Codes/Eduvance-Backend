package com.project.eduvance.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class University {
    @Id
    private String Id;
    private String Name;
    private String ESTD;
    private String Country;
    private String State;
    private String Address;
    private String Phone;
    private String LandlineNumber;
    private String FaxNumber;

    @CreationTimestamp
    private LocalDate CreatedAt;

    @Lob
    private String Photo;

}
