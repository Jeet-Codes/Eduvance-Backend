package com.project.eduvance.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManagementDto {
    private String mtName;
    private String mtEmail;
    private String mtPasswd;
    private String mtGender;
    private String mtBloodGrup;
    private String mtPhoto;
    private String campusId;
}