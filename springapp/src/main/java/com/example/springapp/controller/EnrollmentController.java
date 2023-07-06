package com.example.springapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Enrollment;
import com.example.springapp.repository.EnrollmentRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/enrollment")
public class EnrollmentController {
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	//get all enrollments
	@GetMapping("/enrollments")
	public List<Enrollment> getAllEnrollments(){
		return enrollmentRepository.findAll();
	}
	
	 @GetMapping("/courses/{userId}")
	    public List<Long> getEnrolledCoursesByUserId(@PathVariable Long userId) {
	        List<Long> enrolledCourses = new ArrayList<>();
	        List<Enrollment>enrollments=new ArrayList<>();
	        enrollments=getAllEnrollments();
	        for (Enrollment enrollment : enrollments) {
	            if (enrollment.getUserId() == userId) {
	                enrolledCourses.add(enrollment.getCourseId());
	            }
	        }
	        return enrolledCourses;
	    }
	
	// create enrollment
	@PostMapping("/add")
	public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
		return enrollmentRepository.save(enrollment);
	}
}
