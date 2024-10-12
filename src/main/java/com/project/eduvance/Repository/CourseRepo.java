package com.project.eduvance.Repository;

import com.project.eduvance.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course,String> {

    @Query("SELECT c FROM Course c WHERE c.degree.id IN " +
            "(SELECT d.id FROM Degree d WHERE d.campus.id IN " +
            "(SELECT ca.id FROM Campus ca WHERE ca.university.id = :universityId))")
    List<Course> findCoursesByUniversityId(@Param("universityId") String universityId);

}
