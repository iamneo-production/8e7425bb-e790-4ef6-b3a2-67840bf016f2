package main.java.com.application.learning.services.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.application.learning.Repository.Courses.CoursesRepository;
import main.java.com.application.learning.Models.Courses.Courses;

@Service
public class CoursesService {

    private final CoursesRepository coursesRepository;
    
    @Autowired
    public CoursesService(CoursesRepository coursesRepository){
        this.coursesRepository=coursesRepository;
    }

    public Courses addCourses(Courses courses){
        return coursesRepository.save(courses);
    }

    public List<Courses> findAllCourses(){
        return coursesRepository.findAll();
    }

    public Courses updateCourses(Courses courses){
        return coursesRepository.save(courses);
    }
  
    public void deleteCourses(Long courseid) {
        coursesRepository.deleteCourseByCourseid(courseid);
    }

    public Courses getCourseByCourseid(Long courseid) {
       return coursesRepository.getCourseByCourseid(courseid);
    }

    
}