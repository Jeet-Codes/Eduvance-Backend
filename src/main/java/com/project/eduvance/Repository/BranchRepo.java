package com.project.eduvance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.eduvance.Entity.Branch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BranchRepo extends JpaRepository<Branch, String> {

    @Query("SELECT b FROM Branch b WHERE b.school.id IN " +
            "(SELECT s.id FROM School s WHERE s.degree.id IN " +
            "(SELECT d.id FROM Degree d WHERE d.campus.id IN " +
            "(SELECT ca.id FROM Campus ca WHERE ca.university.id = :universityId)))")
    List<Branch> findBranchesByUniversityId(@Param("universityId") String universityId);

}
