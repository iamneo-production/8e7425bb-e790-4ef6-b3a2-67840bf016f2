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
    private Long lessonid;
    private String lessonname;
    private String lessonurl;
    private Long courseid;
    
    public Lesson() {
    }

    public Lesson(String lessonname, String lessonurl, Long courseid) {
        this.lessonname = lessonname;
        this.lessonurl=lessonurl;
        this.courseid=courseid;
        
    }

    public Long getLessonid() {
        return lessonid;
    }

    public void setLessonid(Long lessonid) {
        this.lessonid = lessonid;
    }

    public String getLessonname() {
        return lessonname;
    }

    public void setLessonname(String lessonname) {
        this.lessonname = lessonname;
    }

    public String getLessonurl() {
        return lessonurl;
    }
    public void setLessonurl(String lessonurl) {
        this.lessonurl = lessonurl;
    }

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    @Override
    public String toString() {
        return "Lessons [lessonid=" + lessonid + ", lessonname=" + lessonname + ", lessonurl=" + lessonurl + ", courseid=" + courseid + "]";
    }

    
}
