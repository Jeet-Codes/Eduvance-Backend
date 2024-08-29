package com.project.eduvance.Service;

import com.project.eduvance.Entity.Student;

import java.util.List;

public interface StudentMethods {

    Student addStudent(Student student);

    Student updateStudent(String id,Student student);

    Student getStudent(String id);

    String deleteStudent(String id);

    List<Student> getStudents();
}
