package com.project.eduvance.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class University {
    @Id
    private String unId;
    private String unName;
    private String unESTD;
    private String unCountry;
    private String unState;
    private String unAddress;
    private String unPhone;
    private String unLandlineNumber;
    private String unFaxNumber;

    @CreationTimestamp
    private LocalDate unCreatedAt;

    @Lob
    private String unPhoto;

}
