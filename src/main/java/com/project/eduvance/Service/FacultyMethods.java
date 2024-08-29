package com.project.eduvance.Service;

import com.project.eduvance.Entity.Faculty;

import java.util.List;

public interface FacultyMethods {

    Faculty createFaculty(Faculty faculty);

    Faculty updateFaculty(String id,Faculty faculty);

    List<Faculty> getFaculties();

    Faculty getFaculty(String id);

    void deleteFaculty(String id);
}
