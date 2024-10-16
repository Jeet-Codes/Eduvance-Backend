package com.project.eduvance.Service.ServiceImp;

import com.project.eduvance.Dto.List.CourseResponse;
import com.project.eduvance.Entity.Course;
import com.project.eduvance.Entity.Degree;
import com.project.eduvance.Exception.ResourceNotFound;
import com.project.eduvance.Repository.CourseRepo;
import com.project.eduvance.Repository.DegreeRepo;
import com.project.eduvance.Service.CourseMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CourseService implements CourseMethods {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private DegreeRepo degreeRepo;

    @Override
    public Course addCourse(String degreeId,Course course) {

        String s = "CR";
        String t = String.valueOf(new Date().getTime()).substring(10, 13);
        course.setId(s+ UUID.randomUUID().toString().substring(0,4)+t);

        // Adding the Degree in Course !
        Degree degree = degreeRepo.findById(degreeId).orElseThrow(() ->
                new RuntimeException("Degree not found"));
        course.setDegree(degree);

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


    public List<CourseResponse> getCoursesV2() {
        List<Course> courses = courseRepo.findAll();
        List<CourseResponse> courseResponses = new ArrayList<>();
        for (Course course : courses) {
            CourseResponse courseResponse = new CourseResponse();
            courseResponse.setId(course.getId());
            courseResponse.setName(course.getName());
            courseResponses.add(courseResponse);
        }
        return courseResponses;
    }

    @Override
    public String deleteCourses() {
        courseRepo.deleteAll();
        return "Deleted all courses";
    }


    @Override
    public List<Course> getCoursesByUniversityId(String universityId) {
        return courseRepo.findCoursesByUniversityId(universityId);
    }
}
