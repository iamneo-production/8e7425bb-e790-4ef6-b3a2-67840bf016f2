package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long>{
	
}
