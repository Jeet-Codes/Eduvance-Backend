package com.project.eduvance.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    @Column(name = "bhDescription")
    private String description;

}

