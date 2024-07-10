package com.project.eduvance.Repository;

import com.project.eduvance.Entity.Campus;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CampusRepo extends JpaRepository<Campus,String> {
}
