package com.project.eduvance.Repository;

import com.project.eduvance.Entity.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DegreeRepo extends JpaRepository<Degree, String> {

    List<Degree> findByCampusCsId(String campusId);
}
