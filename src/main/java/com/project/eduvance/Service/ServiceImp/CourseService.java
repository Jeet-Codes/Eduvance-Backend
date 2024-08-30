package com.project.eduvance.Service.ServiceImp;

import com.project.eduvance.Entity.Course;
import com.project.eduvance.Exception.ResourceNotFound;
import com.project.eduvance.Repository.CourseRepo;
import com.project.eduvance.Service.CourseMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CourseService implements CourseMethods {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public Course addCourse(Course course) {

        String s = "CR";
        String t = String.valueOf(new Date().getTime()).substring(10, 13);
        course.setId(s+ UUID.randomUUID().toString().substring(0,4)+t);

        Course save = courseRepo.save(course);
        return save;
    }

    @Override
    public Course getCourse(String id) {
        Course course = courseRepo.findById(id).orElseThrow(
                () -> new ResourceNotFound("Course", "id", id)
        );

        return course;
    }

    @Override
    public Course updateCourse(String id, Course course) {
        Course stored = courseRepo.findById(id).orElseThrow(
                () -> new ResourceNotFound("Course", "id", id)
        );
        stored.setName(course.getName());
        stored.setDescription(course.getDescription());
        stored.setAuthor(course.getAuthor());
        stored.setCode(course.getCode());
        stored.setCredit(course.getCredit());

        Course updated = courseRepo.save(stored);
        return updated;
    }

    @Override
    public String deleteCourse(String id) {
        courseRepo.findById(id).orElseThrow(
                () -> new ResourceNotFound("Course", "id", id)
        );
        courseRepo.deleteById(id);

        return "Course deleted";
    }

    @Override
    public List<Course> getCourses() {
        return courseRepo.findAll();
    }

    @Override
    public String deleteCourses() {
        courseRepo.deleteAll();
        return "Deleted all courses";
    }
}
