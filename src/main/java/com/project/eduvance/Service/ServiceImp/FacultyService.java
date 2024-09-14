package com.project.eduvance.Service.ServiceImp;

import com.project.eduvance.Dto.List.FacultyResponse;
import com.project.eduvance.Entity.Faculty;
import com.project.eduvance.Entity.User;
import com.project.eduvance.Exception.ResourceNotFound;
import com.project.eduvance.Repository.FacultyRepo;
import com.project.eduvance.Repository.UserRepo;
import com.project.eduvance.Service.FacultyMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<FacultyResponse> getFacultiesV2() {
        List<Faculty> faculties = facultyRepo.findAll();

        // Create a list to store the FacultyResponse objects
        List<FacultyResponse> facultyResponses = new ArrayList<>();

        // Map each Faculty entity to a FacultyResponse DTO
        for (Faculty faculty : faculties) {
            FacultyResponse response = new FacultyResponse();
            response.setName(faculty.getFirstName() + " " + faculty.getLastName()); // Concatenate first and last name
            response.setEmail(faculty.getEmail());

            // Add the mapped FacultyResponse to the list
            facultyResponses.add(response);
        }

        // Return the list of FacultyResponse objects
        return facultyResponses;

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
