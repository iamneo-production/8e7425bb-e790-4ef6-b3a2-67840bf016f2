package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.repository.CourseRepository;
import com.example.springapp.model.Course;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    
    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository=courseRepository;
    }

    public Course addCourse(Course course){
        return courseRepository.save(course);
    }

    public List<Course> findAllCourses(){
        return courseRepository.findAll();
    }

    public Course updateCourses(Course course){
        return courseRepository.save(course);
    }
  
    public void deleteCourses(Long courseid) {
        courseRepository.deleteCourseByCourseid(courseid);
    }

    public Course getCourseByCourseid(Long courseid) {
       return courseRepository.getCourseByCourseid(courseid);
    }
   
}