package com.project.eduvance.Repository;

import com.project.eduvance.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepo extends JpaRepository<Student, String> {
}
