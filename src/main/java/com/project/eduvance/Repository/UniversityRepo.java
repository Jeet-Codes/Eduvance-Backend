package com.project.eduvance.Repository;

import com.project.eduvance.Dto.IdName;
import com.project.eduvance.Entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UniversityRepo extends JpaRepository<University, String> {


}
