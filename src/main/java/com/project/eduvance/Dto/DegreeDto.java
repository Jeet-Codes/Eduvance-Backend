package com.project.eduvance.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DegreeDto {

    private String id;
    private String degreeName;
    private String degreeShortName;
    private Integer durationYears;
    private String campus_id;
}
