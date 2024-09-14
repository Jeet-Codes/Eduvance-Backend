package com.project.eduvance.Dto.List;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SchoolResponse {

    private String id;
    private String schoolName;


}
