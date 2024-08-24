package com.project.eduvance.Repository;

import com.project.eduvance.Entity.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeRepo extends JpaRepository<Degree, String> {
}
