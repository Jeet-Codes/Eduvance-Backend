package com.project.eduvance.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_degree")
public class Degree {

    @Id
    private String id;
    private String degreeName;
    private String degreeShortName;
    private Integer durationYears;
    private Date start;
    private Date end;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campus_id") // Foreign key reference to Campus
    private Campus campus;


}