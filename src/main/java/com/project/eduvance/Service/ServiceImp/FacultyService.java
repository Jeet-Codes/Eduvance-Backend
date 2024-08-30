package com.project.eduvance.Service.ServiceImp;

import com.project.eduvance.Entity.Faculty;
import com.project.eduvance.Entity.User;
import com.project.eduvance.Exception.ResourceNotFound;
import com.project.eduvance.Repository.FacultyRepo;
import com.project.eduvance.Repository.UserRepo;
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


    @Autowired
    private UserRepo userRepo;


    @Override
    public Faculty createFaculty(Faculty faculty) {
        String s = "FT";
        String t = String.valueOf(new Date().getTime()).substring(10, 13);
        faculty.setId(s+ UUID.randomUUID().toString().substring(0,4)+t);

        Faculty storedFaculty = facultyRepo.save(faculty);

        User ftUser=User.builder()
                .userId(storedFaculty.getId())
                .userPasswd(storedFaculty.getPassword())
                .userEmail(storedFaculty.getEmail())
                .userName(storedFaculty.getFirstName()+" "+storedFaculty.getLastName())
                .build();
        userRepo.save(ftUser);

        return storedFaculty;
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
