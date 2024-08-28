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
public class Faculty {
    @Id
    @Column(name = "ftId")
    private String id;

    @Column(name = "ftFirstName")
    private String firstName;

    @Column(name = "ftLastName")
    private String lastName;

    @Column(name = "ftEmail")
    private String email;

    @Column(name = "ftPassword")
    private String password;

    @Column(name = "ftPhone")
    private String phone;

    @Column(name = "ftBloodGroup")
    private String bloodGroup;

    @Column(name = "ftQualification")
    private String qualification;

    @Column(name = "ftDesignation")
    private String designation;

    @Column(name = "ftSpecialDesignation")
    private String specialDesignation;

    @Column(name = "ftPhoto")
    private String photo;


}
