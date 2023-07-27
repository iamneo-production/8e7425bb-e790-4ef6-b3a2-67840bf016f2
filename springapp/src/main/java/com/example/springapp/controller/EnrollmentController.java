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
import com.example.springapp.repository.EnrollmentRepository;
import com.example.springapp.service.CourseService;

@RestController
//santhosh
// @CrossOrigin(origins = "https://8081-cbbdbceccaaadcdddffaedcbcabfdfafdade.project.examly.io")

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
@CrossOrigin(origins = "https://8081-caccdedfdbdccefeadcdddffaedcbcabfdfafdade.project.examly.io")

@RequestMapping("/enrollment")
public class EnrollmentController {
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@Autowired
	private CourseService courseService;

	//get all enrollments
	@GetMapping
	public ResponseEntity<List<Enrollment>> getAllEnrollments(){
		List<Enrollment> enrollment= enrollmentRepository.findAll();
		return new ResponseEntity<>(enrollment,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Enrollment> getEnrollmentbyId(@PathVariable("Id") Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id).get();
        return new ResponseEntity<>(enrollment, HttpStatus.OK);
    }
	
	// create enrollment
	@PostMapping
	public ResponseEntity<Enrollment> createEnrollment(@RequestBody Enrollment enrollment) {
		Enrollment newEnrollment = enrollmentRepository.save(enrollment);
		return new ResponseEntity<>(newEnrollment,HttpStatus.CREATED);
	}


    @GetMapping("/getEnrolledCourses/{userId}")
    public ResponseEntity<List<Course>> getEnrolledCoursesbyUserId(@PathVariable("userId") Long userId){
        List<Enrollment> enrollments = enrollmentRepository.findEnrollmentsByUserId(userId);
		List<Course> courses = new ArrayList<>();
		for(Enrollment enrollment:enrollments){
			Course course = courseService.getCourseByCourseId(enrollment.getCourseId());
			courses.add(course);
		}
		return new ResponseEntity<List<Course>>(courses,HttpStatus.OK);
    }

    @GetMapping("/getEnrollments/{userId}")
    public ResponseEntity<List<Enrollment>> getEnrollmentsbyUserId(@PathVariable("userId") Long userId){
        List<Enrollment> enrollments = enrollmentRepository.findEnrollmentsByUserId(userId);
		return new ResponseEntity<List<Enrollment>>(enrollments,HttpStatus.OK);
    }

	@GetMapping("/getEnrollmentsByCourseId/{courseId}")
	public ResponseEntity<List<Enrollment>> getEnrollmentsByCourseId(@PathVariable("courseId") Long courseId){
		List<Enrollment> enrollments = enrollmentRepository.findEnrollmentsByCourseId(courseId);
		return new ResponseEntity<List<Enrollment>>(enrollments, HttpStatus.OK);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteEnrollmentById(@PathVariable("id") Long id){
		enrollmentRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/deleteAllByCourseId/{courseId}")
	public ResponseEntity<?> deleteAllEnrollmentByCourseId(@PathVariable("courseId") Long courseId){
		List<Enrollment> enrollments = enrollmentRepository.findEnrollmentsByCourseId(courseId);
		for(int i=0;i<enrollments.size();i++){
			enrollmentRepository.deleteById(enrollments.get(i).getId());
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}



}