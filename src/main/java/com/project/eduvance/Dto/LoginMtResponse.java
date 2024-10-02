package com.project.eduvance.Dto;

import com.project.eduvance.Entity.Management;
import lombok.Data;

@Data
public class LoginMtResponse {

    private String mtName;
    private String mtEmail;
    private String mtPasswd;
    private String mtPhone;
    private String mtGender;
    private String mtBloodGrup;
    private String mtPhoto;
    private String campusId;
    private String campusName;
    private String unId;
    private String unName;
}
