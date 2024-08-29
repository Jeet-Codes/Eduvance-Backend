package com.project.eduvance.Service.ServiceImp;

import com.project.eduvance.Entity.Faculty;
import com.project.eduvance.Exception.ResourceNotFound;
import com.project.eduvance.Repository.FacultyRepo;
import com.project.eduvance.Service.FacultyMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class FacultyService implements FacultyMethods {

    @Autowired
    private FacultyRepo facultyRepo;

    @Override
    public Faculty createFaculty(Faculty faculty) {
        String s = "FT";
        String t = String.valueOf(new Date().getTime()).substring(10, 13);
        faculty.setId(s+ UUID.randomUUID().toString().substring(0,4)+t);

        Faculty save = facultyRepo.save(faculty);


        return save;
    }

    @Override
    public Faculty updateFaculty(String id, Faculty faculty) {
        Faculty stored = facultyRepo.findById(id).orElseThrow(
                () -> new ResourceNotFound("Faculty", "id", id)
        );
        return stored;
    }

    @Override
    public List<Faculty> getFaculties() {
        return facultyRepo.findAll();
    }

    @Override
    public Faculty getFaculty(String id) {
        Faculty stored = facultyRepo.findById(id).orElseThrow(
                () -> new ResourceNotFound("Faculty", "id", id)
        );

        return stored;
    }

    @Override
    public String deleteFaculty(String id) {
        Faculty stored = facultyRepo.findById(id).orElseThrow(
                () -> new ResourceNotFound("Faculty", "id", id)
        );
        facultyRepo.delete(stored);
        return "Faculty deleted";

    }
}
