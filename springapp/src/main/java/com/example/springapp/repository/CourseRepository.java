package com.example.springapp.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Course;

@Transactional
@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    
    void deleteCourseByCourseId(Long courseId);

    Course getCourseByCourseId(Long courseId);
   
    @Query(value = "select * from course where instructor_id=?1",nativeQuery = true)
	List<Course> findCoursesByInstructorId(Long instructorId); 
}