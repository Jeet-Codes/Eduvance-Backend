package com.project.eduvance.Controllers;

import com.project.eduvance.Entity.Course;
import com.project.eduvance.Service.ServiceImp.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("eduvance/course")
@CrossOrigin("*")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        Course stored = courseService.addCourse(course);
        return new ResponseEntity<>(stored, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable String id) {
        Course stored = courseService.getCourse(id);
        return new ResponseEntity<>(stored, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable String id) {
        String deleted = courseService.deleteCourse(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

    // This is for deleting all Courses

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAllCourses() {
        String deleteCourses = courseService.deleteCourses();
        return new ResponseEntity<>(deleteCourses, HttpStatus.OK);
    }
}
