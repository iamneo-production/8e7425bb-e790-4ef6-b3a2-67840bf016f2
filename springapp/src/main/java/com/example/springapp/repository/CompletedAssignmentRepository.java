package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.CompletedAssignments;

@Repository
public interface CompletedAssignmentRepository extends JpaRepository<CompletedAssignments,Long>{

       @Query(value = "select * from completed_assignments where course_id=?1",nativeQuery = true)
	    List<CompletedAssignments> findallBycourseId(Long courseId);

       @Query(value = "select * from completed_assignments where user_id=?1",nativeQuery = true)
	    List<CompletedAssignments> findallByuserId(Long userId);

       @Query(value = "select * from completed_assignments where instructor_id=?1",nativeQuery = true)
	    List<CompletedAssignments> findallByInstructorId(Long instructorId);

       @Query(value = "select * from completed_assignments where assignment_id=?1",nativeQuery = true)
	    List<CompletedAssignments> findallByAssignmentId(Long assignmentId);
}
