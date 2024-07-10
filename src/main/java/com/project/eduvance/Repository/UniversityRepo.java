package com.project.eduvance.Repository;

import com.project.eduvance.Entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepo extends JpaRepository<University, String> {
}
