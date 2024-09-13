package com.project.eduvance.Service;

import java.util.List;

import com.project.eduvance.Dto.SchoolDto;
import com.project.eduvance.Entity.School;

public interface SchoolMethods {
   SchoolDto addSchool(SchoolDto school);

   School addSchoolWithDegree(SchoolDto school, String id);

   List<School> listSchool();
}
