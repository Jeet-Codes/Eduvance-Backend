package com.project.eduvance.Service;

import com.project.eduvance.Dto.ApiResponse;
import com.project.eduvance.Entity.University;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UniversityMethods {
    University createUniversity(University university);

    University updateUniversity(String unId, University university);

    ApiResponse deleteUniversity(String unId);

    University getUniversity(String unId);

    List<University> getUniversities();
}
