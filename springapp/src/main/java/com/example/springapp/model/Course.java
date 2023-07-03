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
    @GeneratedValue(generator = "courses_gen", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "courses_gen", sequenceName = "courses_sequence", initialValue = 1, allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long courseid;
    private String coursename;
    private String courselevel;
    private Long courseduration;
    private String coursedescription;
    private Long enrolledcount;
    private String imageUrl;
    private Long instructorid;
    
    
    public Course() {
    }

    public Course(String coursename, String courselevel, Long courseduration, String coursedescription, Long enrolledcount, String imageUrl, Long instructorid) {
        this.coursename = coursename;
        this.courselevel = courselevel;
        this.courseduration = courseduration;
        this.coursedescription = coursedescription;
        this.enrolledcount = enrolledcount;
        this.imageUrl = imageUrl;
        this.instructorid = instructorid;
    }

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCourselevel() {
        return courselevel;
    }

    public void setCourselevel(String courselevel) {
        this.courselevel = courselevel;
    }

    public Long getCourseduration() {
        return courseduration;
    }

    public void setCourseduration(Long courseduration) {
        this.courseduration = courseduration;
    }

    public String getCoursedescription() {
        return coursedescription;
    }

    public void setCoursedescription(String coursedescription) {
        this.coursedescription = coursedescription;
    }

    public Long getEnrolledcount() {
        return enrolledcount;
    }

    public void setEnrolledcount(Long enrolledcount) {
        this.enrolledcount = enrolledcount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getInstructorid() {
        return instructorid;
    }

    public void setInstructorid(Long instructorid) {
        this.instructorid = instructorid;
    }
            
    @Override
    public String toString() {
        return "Courses [courseid=" + courseid 
            + ", coursename=" + coursename 
            + ", courselevel=" + courselevel
            + ", courseduration=" + courseduration 
            + ", coursedescription=" + coursedescription 
            + ", enrolledcount=" + enrolledcount 
            + ", imageUrl=" + imageUrl
            + ", instructorid=" + instructorid + "]";

    }

}