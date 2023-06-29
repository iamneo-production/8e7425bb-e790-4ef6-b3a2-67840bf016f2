package main.java.com.application.learning.Repository.Courses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.com.application.learning.Models.Courses.Courses;

@Repository
public interface CoursesRepository extends JpaRepository<Courses,Long> {
    
    void deleteCourseByCourseid(Long courseid);

    Courses getCourseByCourseid(Long courseid);
   
}