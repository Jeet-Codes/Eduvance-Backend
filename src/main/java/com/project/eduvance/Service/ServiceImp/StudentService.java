package com.project.eduvance.Service.ServiceImp;

import com.project.eduvance.Entity.Student;
import com.project.eduvance.Entity.User;
import com.project.eduvance.Exception.ResourceNotFound;
import com.project.eduvance.Repository.StudentRepo;
import com.project.eduvance.Repository.UserRepo;
import com.project.eduvance.Service.StudentMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService implements StudentMethods {


    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Student addStudent(Student student) {
        String s = "ST";
        String t = String.valueOf(new Date().getTime()).substring(10, 13);
        student.setId(s+ UUID.randomUUID().toString().substring(0,4)+t);
        Student storedStudent = studentRepo.save(student);

        User stUser=User.builder()
                .userId(storedStudent.getId())
                .userName(storedStudent.getFirstName()+" "+storedStudent.getLastName())
                .userEmail(storedStudent.getEmail())
                .userPasswd(storedStudent.getPassword())
                .build();

        userRepo.save(stUser);

        return storedStudent;
    }

    @Override
    public Student updateStudent(String id, Student student) {
        Student stored = studentRepo.findById(id).orElseThrow(
                () -> new ResourceNotFound("Student", "id", id)
        );

        // Not Completed
        return stored;
    }

    @Override
    public Student getStudent(String id) {
        Student stored = studentRepo.findById(id).orElseThrow(
                () -> new ResourceNotFound("Student", "id", id)
        );
        return stored;
    }

    @Override
    public String deleteStudent(String id) {

        studentRepo.findById(id).orElseThrow(
                () -> new ResourceNotFound("Student","id",id)
        );

        studentRepo.deleteById(id);

        return "Student deleted";
    }

    @Override
    public List<Student> getStudents() {
        return List.of();
    }
}
