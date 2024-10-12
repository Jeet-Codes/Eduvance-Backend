package com.project.eduvance.Service;

import java.util.List;

import com.project.eduvance.Dto.List.SchoolResponse;
import com.project.eduvance.Dto.SchoolDto;
import com.project.eduvance.Entity.School;

public interface SchoolMethods {
   SchoolDto addSchool(SchoolDto school);

   Object addSchoolWithDegree(SchoolDto school, String id);

   List<SchoolResponse> listSchool();


   // by unID get Schools
   List<School> getSchoolsByUniversityId(String universityId);
}
