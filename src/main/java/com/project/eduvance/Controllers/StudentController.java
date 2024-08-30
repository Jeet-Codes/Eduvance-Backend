package com.project.eduvance.Controllers;


import com.project.eduvance.Entity.Student;
import com.project.eduvance.Service.ServiceImp.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eduvance/student")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student stored = studentService.addStudent(student);
        return new ResponseEntity<>(stored, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable String id) {
        Student stored = studentService.getStudent(id);
        return new ResponseEntity<>(stored, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        String deleteStudent = studentService.deleteStudent(id);
        return new ResponseEntity<>(deleteStudent, HttpStatus.OK);
    }
}
