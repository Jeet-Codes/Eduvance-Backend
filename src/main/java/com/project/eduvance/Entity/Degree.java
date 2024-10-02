package com.project.eduvance.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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




}