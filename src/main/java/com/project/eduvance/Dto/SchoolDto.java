package com.project.eduvance.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolDto {
    private String id;
    private String schoolName;
    private String schoolDescription;

    public SchoolDto(String name, String description) {
    }
}
