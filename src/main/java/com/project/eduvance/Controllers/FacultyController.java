package com.project.eduvance.Controllers;


import com.project.eduvance.Dto.List.FacultyResponse;
import com.project.eduvance.Entity.Faculty;
import com.project.eduvance.Service.ServiceImp.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eduvance/faculty")
@CrossOrigin("*")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @PostMapping
    public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty faculty) {
        Faculty stored = facultyService.createFaculty(faculty);
        return new ResponseEntity<>(stored, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable String id) {
        Faculty stored = facultyService.getFaculty(id);
        return new ResponseEntity<>(stored, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Faculty>> getAllFaculty() {
        List<Faculty> faculties = facultyService.getFaculties();
        return new ResponseEntity<>(faculties, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFaculty(@PathVariable String id) {
        String delete = facultyService.deleteFaculty(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }


    @GetMapping("/v2/all")
    public ResponseEntity<List<FacultyResponse>> searchFaculty() {
        List<FacultyResponse> facultiesV2 = facultyService.getFacultiesV2();
        return new ResponseEntity<>(facultiesV2, HttpStatus.OK);
    }
}
