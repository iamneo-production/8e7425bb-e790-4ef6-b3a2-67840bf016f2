package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Assignment;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment,Long>{

    @Query(value = "select * from assignment where instructor_id=?1",nativeQuery = true)
	List<Assignment> findAssignmentsByInstructorId(Long instructorId);

    @Query(value = "select * from assignment where course_id=?1",nativeQuery = true)
	List<Assignment> findAssignmentsByCourseId(Long courseId);
}
