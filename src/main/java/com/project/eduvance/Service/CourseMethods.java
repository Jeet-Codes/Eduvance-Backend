package com.project.eduvance.Service;

import com.project.eduvance.Entity.Course;

import java.util.List;

public interface CourseMethods {

    Course addCourse(String degreeId,Course course);

    Course getCourse(String id);

    Course updateCourse(String id,Course course);

    String deleteCourse(String id);

    List<Course> getCourses();

    String deleteCourses();

    List<Course> getCoursesByUniversityId(String universityId);
}
