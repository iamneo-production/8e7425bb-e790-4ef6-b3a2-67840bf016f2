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
@Table(name="Lesson")
public class Lesson implements Serializable {

    @Id
    @GeneratedValue(generator = "lesson_gen", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "lesson_gen", sequenceName = "lesson_sequence", initialValue = 1, allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private Long lessonId;
    private String lessonName;
    private String lessonDescription;
    private Long courseId;
    
    public Lesson() {
    }

    public Lesson(Long lessonId,String lessonName, String lessonDescription, Long courseId) {
        this.lessonId=lessonId;
        this.lessonName = lessonName;
        this.lessonDescription=lessonDescription;
        this.courseId=courseId;
        
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonDescription() {
        return lessonDescription;
    }
    public void setLessonDescription(String lessonDescription) {
        this.lessonDescription = lessonDescription;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Lessons [lessonId=" + lessonId + ", lessonName=" + lessonName + ", lessonDescription=" + lessonDescription + ", courseId=" + courseId + "]";
    }

    
}
