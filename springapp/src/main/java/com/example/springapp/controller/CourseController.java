package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Course;
import com.example.springapp.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;       
    }
    // To get all the courses
    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> course = courseService.findAllCourses();
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    // To add a new course
    @PostMapping("/add")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        Course newCourse = courseService.addCourse(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }

    // To update a course
    @PutMapping("/update")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Course> updateCourses(@RequestBody Course course) {
        Course updatedCourse = courseService.updateCourses(course);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    // To delete the course based on courseid
    @DeleteMapping("/delete/{courseid}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> deleteCourses(@PathVariable("courseid") Long courseid) {
        courseService.deleteCourses(courseid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // To get the course based on courseid
    @GetMapping("/{courseid}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Course> getCourseByCourseid(@PathVariable("courseid") Long courseid) {
        Course course = courseService.getCourseByCourseid(courseid);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

}
