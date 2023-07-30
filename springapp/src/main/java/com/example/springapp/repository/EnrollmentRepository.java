package com.example.springapp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Enrollment;

@Transactional
@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Long>{
	
     @Query(value = "select * from enrollments where user_id=?1",nativeQuery = true)
	List<Enrollment> findEnrollmentsByUserId(Long userId);
     
     @Query(value = "select * from enrollments where course_id=?1",nativeQuery = true)
	List<Enrollment> findEnrollmentsByCourseId(Long courseId);
     
}