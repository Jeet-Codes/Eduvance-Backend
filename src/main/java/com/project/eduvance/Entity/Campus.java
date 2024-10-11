package com.project.eduvance.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Campus {
    @Id
    private String csId;
    private String csName;
    private Integer csESTD;
    private String csState;
    private String csAddress;
    private String csPhone;
    private String csLandlineNumber;

    @CreationTimestamp
    private LocalDateTime csDateOfJoin;

    private String csPhoto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id")
    @JsonIgnore
    private University university;

    @OneToMany(mappedBy = "campus")
    private List<Degree> degrees;

    @OneToMany(mappedBy = "campus",cascade = CascadeType.PERSIST)
    private List<Management> managements;

    //when delete
//    public void deleteManagement(Management management) {
//        managements.remove(management);
//        management.setCampus(null);
//    }





}
