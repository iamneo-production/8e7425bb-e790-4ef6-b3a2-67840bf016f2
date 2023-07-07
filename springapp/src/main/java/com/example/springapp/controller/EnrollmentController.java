package com.example.springapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	@GetMapping
	public ResponseEntity<List<Enrollment>> getAllEnrollments(){
		List<Enrollment> enrollment= enrollmentRepository.findAll();
		return new ResponseEntity<>(enrollment,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
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
}
