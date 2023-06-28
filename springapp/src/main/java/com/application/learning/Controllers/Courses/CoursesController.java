package main.java.com.application.learning.controllers.courses;

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

import main.java.com.application.learning.Models.Courses.Courses;
import main.java.com.application.learning.Services.Courses.CoursesRepository;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    private final CoursesService coursesService;
    
    @Autowired
    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;       
    }

    // To get all the courses
    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Courses>> getAllCourses() {
        List<Courses> courses = coursesService.findAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    // To add a new course
    @PostMapping("/add")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Courses> addCourses(@RequestBody Courses courses) {
        Courses newCourse = coursesService.addCourses(courses);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }

    // To update a course
    @PutMapping("/update")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Courses> updateCourses(@RequestBody Courses courses) {
        Courses updatedCourse = coursesService.updateCourses(courses);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    // To delete the course based on courseid
    @DeleteMapping("/delete/{courseid}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> deleteCourses(@PathVariable("courseid") Long courseid) {
        coursesService.deleteCourses(courseid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // To get the course based on courseid
    @GetMapping("/{courseid}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Courses> getCourseByCourseid(@PathVariable("courseid") Long courseid) {
        Courses course = coursesService.getCourseByCourseid(courseid);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

}
