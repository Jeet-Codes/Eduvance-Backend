package com.project.eduvance.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;



import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class University {
    @Id
    private String unId;
    private String unName;
    private String unCountry;
    private String unState;
    private String unAddress;
    private String unPhone;
    private String unLandlineNumber;
    private String unFaxNumber;

    @CreationTimestamp
    private LocalDateTime unCreatedAt;

    @Lob
    private String unPhoto;

}
