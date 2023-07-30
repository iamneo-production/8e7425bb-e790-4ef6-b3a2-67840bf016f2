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
//santhosh
@CrossOrigin(origins = "https://8081-cbbdbceccaaadcdddffaedcbcabfdfafdade.project.examly.io")

//ramesh
//@CrossOrigin(origins = "https://8081-febcaabfefeacfadcdddffaedcbcabfdfafdade.project.examly.io")

//rithick
//@CrossOrigin(origins = "https://8081-ccfbbdadfbadcdddffaedcbcabfdfafdade.project.examly.io")

//oviya
//@CrossOrigin(origins = "https://8081-bfbbbeacbadcdddffaedcbcabfdfafdade.project.examly.io")

//joshika
//@CrossOrigin(origins = "https://8081-fdfedfdaaaacfedbadcdddffaedcbcabfdfafdade.project.examly.io")

//sumanth
//@CrossOrigin(origins = "https://8081-daeacaadbcfaeadcdddffaedcbcabfdfafdade.project.examly.io")

//mrinal
//@CrossOrigin(origins = "https://8081-fbbfbccabebadcdddffaedcbcabfdfafdade.project.examly.io")

//muskan
//@CrossOrigin(origins = "https://8081-ddefcefdabfbdadcdddffaeeaeaadbdbabf.project.examly.io")

//rishik
//@CrossOrigin(origins = "https://8081-caccdedfdbdccefeadcdddffaedcbcabfdfafdade.project.examly.io")

@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;       
    }
    // To get all the courses
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> course = courseService.findAllCourses();
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    // To add a new course
    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        Course newCourse = courseService.addCourse(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }

    // To update a course
    @PutMapping("/update")
    public ResponseEntity<Course> updateCourses(@RequestBody Course course) {
        Course updatedCourse = courseService.updateCourses(course);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    // To delete the course based on courseid
    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<?> deleteCourses(@PathVariable("courseId") Long courseId) {
        courseService.deleteCourses(courseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // To get the course based on courseid
    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseByCourseId(@PathVariable("courseId") Long courseId) {
        Course course = courseService.getCourseByCourseId(courseId);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    //To get courses based on instructor id
    @GetMapping("/instructor/{instructorId}")
    public ResponseEntity<List<Course>> getCourseByInstructorId(@PathVariable("instructorId") Long instructorId) {
        List<Course> course = courseService.getCoursesByInstructorId(instructorId);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }
}
