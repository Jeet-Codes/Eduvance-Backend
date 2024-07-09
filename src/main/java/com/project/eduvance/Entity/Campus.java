package com.project.eduvance.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Campus {
    @Id
    private String csId;
    private String csName;

    @ManyToOne
    private University university;

    private Integer csESTD;
    private String csState;
    private String csAddress;
    private String csPhone;
    private String csLandlineNumber;

    @CreationTimestamp
    private LocalDateTime csDateOfJoin;

}
