package com.project.eduvance.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    @Column(name = "bhId")
    private String Id;

    @Column(name = "bhName")
    private String Name;

    @Column(name = "bhDesc")
    private String Description;

    private Date insertedDate;


//    @OneToMany
//    private List<Degree> degrees;
}
