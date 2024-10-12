package com.project.eduvance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.eduvance.Entity.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchoolRepo extends JpaRepository<School, String> {

    @Query("SELECT s FROM School s JOIN s.degree d JOIN d.campus c WHERE c.university.unId = :universityId")
    List<School> findSchoolsByUniversityId(@Param("universityId") String universityId);
}
