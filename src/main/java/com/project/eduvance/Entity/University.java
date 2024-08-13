package com.project.eduvance.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
    private String unPhoto;

    @Column(name="dateOfJoin")
    @UpdateTimestamp
    private LocalDateTime unCreatedAt;


    @OneToMany(mappedBy = "university",cascade = CascadeType.PERSIST )
    private List<Campus> campuses;

    public void addCampus(Campus campus) {
        campuses.add(campus);
        campus.setUniversity(this);
    }

    public void removeCampus(Campus campus) {
        campuses.remove(campus);
        campus.setUniversity(null);
    }


}
