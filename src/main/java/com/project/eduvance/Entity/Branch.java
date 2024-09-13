package com.project.eduvance.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Branch {

    @Id
    @Column(name = "bhId")
    private String id;

    @Column(name = "bhName")
    private String name;

    @Column(name = "bhDesc")
    private String description;

    @ManyToOne
    @JoinColumn(name = "school_id")
    @JsonIgnore
    private School school;
}

