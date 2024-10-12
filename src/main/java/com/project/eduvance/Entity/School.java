package com.project.eduvance.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class School {
    @Id
    @Column(name = "schoolId")
    private String Id;

    @Column(name = "schoolName")
    private String Name;

    @Column(name = "schoolDesc")
    private String Description;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<Branch> branches;

    @ManyToOne
    @JoinColumn(name = "degree_id") //unidirectional
    @JsonIgnore
    private Degree degree;



}
