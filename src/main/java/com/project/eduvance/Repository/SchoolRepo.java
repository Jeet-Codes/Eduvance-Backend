package com.project.eduvance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.eduvance.Entity.School;

public interface SchoolRepo extends JpaRepository<School, String> {

}
