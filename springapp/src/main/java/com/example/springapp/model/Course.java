package com.example.springapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(generator = "course_gen", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "course_gen", sequenceName = "course_sequence", initialValue = 1, allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long courseId;
    private String courseName;
    private String courseDescription;
    private Long instructorId;
    
    
    public Course() {
    }

    public Course(Long courseId, String courseName, String courseDescription, Long instructorId) {
        this.courseId=courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.instructorId = instructorId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

     public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    
    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }
            
    @Override
    public String toString() {
        return "Courses [courseId=" + courseId 
            + ", courseName=" + courseName 
            + ", courseDescription=" + courseDescription 
            + ", instructorId=" + instructorId + "]";

    }

}