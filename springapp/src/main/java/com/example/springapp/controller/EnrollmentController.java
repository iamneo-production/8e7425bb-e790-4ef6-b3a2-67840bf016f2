package com.example.springapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Course;
import com.example.springapp.model.Enrollment;
import com.example.springapp.service.CourseService;
import com.example.springapp.service.EnrollmentService;

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

@RequestMapping("/enrollment")
public class EnrollmentController {
	@Autowired
	private EnrollmentService enrollmentService;

	//get all enrollments
	@GetMapping
	public ResponseEntity<List<Enrollment>> getAllEnrollments(){
		return enrollmentService.getAllEnrollments();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Enrollment> getEnrollmentbyId(@PathVariable("Id") Long id) {
        return enrollmentService.getEnrollmentbyId(id);
    }
	
	// create enrollment
	@PostMapping
	public ResponseEntity<Enrollment> createEnrollment(@RequestBody Enrollment enrollment) {
		return enrollmentService.createEnrollment(enrollment);
	}


    @GetMapping("/getEnrolledCourses/{userId}")
    public ResponseEntity<List<Course>> getEnrolledCoursesbyUserId(@PathVariable("userId") Long userId){
        return enrollmentService.getEnrolledCoursesbyUserId(userId);
    }

    @GetMapping("/getEnrollments/{userId}")
    public ResponseEntity<List<Enrollment>> getEnrollmentsbyUserId(@PathVariable("userId") Long userId){
        return enrollmentService.getEnrollmentsbyUserId(userId);
    }

	@GetMapping("/getEnrollmentsByCourseId/{courseId}")
	public ResponseEntity<List<Enrollment>> getEnrollmentsByCourseId(@PathVariable("courseId") Long courseId){
		return enrollmentService.getEnrollmentsByCourseId(courseId);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteEnrollmentById(@PathVariable("id") Long id){
		return enrollmentService.deleteEnrollmentById(id);
	}

	@DeleteMapping("/deleteAllByCourseId/{courseId}")
	public ResponseEntity<?> deleteAllEnrollmentByCourseId(@PathVariable("courseId") Long courseId){
		return enrollmentService.deleteAllEnrollmentByCourseId(courseId);
	}



}