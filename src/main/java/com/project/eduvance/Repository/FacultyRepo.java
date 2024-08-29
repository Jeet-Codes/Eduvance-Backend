package com.project.eduvance.Repository;

import com.project.eduvance.Entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepo extends JpaRepository<Faculty, String> {
}
