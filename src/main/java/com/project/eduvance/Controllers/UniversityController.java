package com.project.eduvance.Controllers;

import com.project.eduvance.Dto.IdName;
import com.project.eduvance.Entity.University;
import com.project.eduvance.Service.ServiceImp.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/eduvance/admin/university")
public class UniversityController {
    @Autowired
    private UniversityService universityService;

    @PostMapping
    public ResponseEntity<University> createUniversity(@RequestBody University un1) {
        University createdUniversity = universityService.createUniversity(un1);
        return new ResponseEntity<>(createdUniversity, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<University> getUniversityById(@PathVariable String id) {
        University storedUn=universityService.getUniversity(id);
        return new ResponseEntity<>(storedUn, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<University>> getUniversitys() {
        List<University> uns = universityService.getUniversities();
        return new ResponseEntity<>(uns, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<University> updateUniversity(@PathVariable String id, @RequestBody University un1) {
        University updatedUn = universityService.updateUniversity(id, un1);
        return new ResponseEntity<>(updatedUn, HttpStatus.OK);
    }

    @GetMapping("/ids")
    public List<IdName> getUniversityIdName() {
        return universityService.getUniversityIds();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUniversity(@PathVariable String id) {
        universityService.deleteUniversity(id);
        return new ResponseEntity<>("University having id: "+id+" deleted Successfully !",HttpStatus.ACCEPTED);
    }
}
