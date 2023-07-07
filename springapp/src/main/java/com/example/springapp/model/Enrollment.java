<<<<<<< HEAD
package main.java.com.example.springapp.model;

public class Enrollment {
    private Long id;
    private Long courseid;
    private Long Instructorid;
    
    public Enrollment() {
    }
    
    
=======
package com.example.springapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Enrollments")
public class Enrollment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="user_Id")
	private Long userId;
	
	@Column(name="course_Id")
	private Long courseId;
	
	public Enrollment() {
		
	}
	public Enrollment(Long id,Long userId, Long courseId) {
		super();
		this.id=id;
		this.userId = userId;
		this.courseId = courseId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
>>>>>>> c737eb22183f83eeb3461c1570f602b766a530a4
}
