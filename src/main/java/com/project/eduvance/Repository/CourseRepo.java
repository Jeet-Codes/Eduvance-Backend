package com.project.eduvance.Repository;

import com.project.eduvance.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,String> {

}
