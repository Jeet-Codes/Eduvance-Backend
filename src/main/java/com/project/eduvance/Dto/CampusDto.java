package com.project.eduvance.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CampusDto {
    private String csId;
    private String csName;
    private Integer csESTD;
    private String csState;
    private String csAddress;
    private String csPhone;
    private String csLandlineNumber;
    private String unId;
}
