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
public class Student {
    @Id
    @Column(name = "stId")
    private String id;

    @Column(name = "stFirstName")
    private String firstName;

    @Column(name = "stLastName")
    private String lastName;

    @Column(name = "stEmail")
    private String email;

    @Column(name = "stPassword")
    private String password;

    @Column(name = "stPhone")
    private String phone;

    @Column(name = "stGender")
    private String gender;

    @Column(name = "stParentName")
    private String parentName;

    @Column(name = "stParentNumber")
    private String parentNumber;

    @Column(name = "stBloodGroup")
    private String bloodGroup;

    @Column(name = "stPhoto")
    private String photo;
}