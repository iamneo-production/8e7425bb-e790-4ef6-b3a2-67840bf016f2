package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    
    void deleteCourseByCourseId(Long courseId);

    Course getCourseByCourseId(Long courseId);
   
}