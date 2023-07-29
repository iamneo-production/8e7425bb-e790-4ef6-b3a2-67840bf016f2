package com.example.springapp.service;
import java.util.List;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springapp.repository.EnrollmentRepository;
import com.example.springapp.model.Course;
import com.example.springapp.model.Enrollment;
import com.example.springapp.service.CourseService;

@Service
public class EnrollmentService {
   
    @Autowired
    private EnrollmentRepository enrollmentRepository;
	@Autowired
	private CourseService courseService;

    public ResponseEntity<List<Enrollment>> getAllEnrollments(){
		List<Enrollment> enrollment= enrollmentRepository.findAll();
		return new ResponseEntity<>(enrollment,HttpStatus.OK);
	}
	
    public ResponseEntity<Enrollment> getEnrollmentbyId(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id).get();
		if(enrollment!=null) return new ResponseEntity<>(enrollment, HttpStatus.OK);
		else return new ResponseEntity<>(enrollment,HttpStatus.NOT_FOUND);
    }
	
	// create enrollment
	public ResponseEntity<Enrollment> createEnrollment(Enrollment enrollment) {
		Enrollment newEnrollment = enrollmentRepository.save(enrollment);
		return new ResponseEntity<>(newEnrollment,HttpStatus.CREATED);
	}


    public ResponseEntity<List<Course>> getEnrolledCoursesbyUserId(Long userId){
        List<Enrollment> enrollments = enrollmentRepository.findEnrollmentsByUserId(userId);
		List<Course> courses = new ArrayList<>();
		for(Enrollment enrollment:enrollments){
			Course course = courseService.getCourseByCourseId(enrollment.getCourseId());
			courses.add(course);
		}
		return new ResponseEntity<List<Course>>(courses,HttpStatus.OK);
    }

    public ResponseEntity<List<Enrollment>> getEnrollmentsbyUserId(Long userId){
        List<Enrollment> enrollments = enrollmentRepository.findEnrollmentsByUserId(userId);
		return new ResponseEntity<List<Enrollment>>(enrollments,HttpStatus.OK);
    }

	public ResponseEntity<List<Enrollment>> getEnrollmentsByCourseId(Long courseId){
		List<Enrollment> enrollments = enrollmentRepository.findEnrollmentsByCourseId(courseId);
		return new ResponseEntity<List<Enrollment>>(enrollments, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteEnrollmentById(Long id){
		Enrollment enrollment = enrollmentRepository.findById(id).get();
		if(enrollment==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		enrollmentRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	public ResponseEntity<?> deleteAllEnrollmentByCourseId(Long courseId){
		List<Enrollment> enrollments = enrollmentRepository.findEnrollmentsByCourseId(courseId);
		for(int i=0;i<enrollments.size();i++){
			enrollmentRepository.deleteById(enrollments.get(i).getId());
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
