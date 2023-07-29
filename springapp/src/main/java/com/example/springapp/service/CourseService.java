package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Course;

public interface CourseService {

    public Course addCourse(Course course);

    public List<Course> findAllCourses();

    public Course updateCourses(Course course);

    public void deleteCourses(Long courseId);

    public Course getCourseByCourseId(Long courseId);

    public List<Course> getCoursesByInstructorId(Long instructorId);
}
