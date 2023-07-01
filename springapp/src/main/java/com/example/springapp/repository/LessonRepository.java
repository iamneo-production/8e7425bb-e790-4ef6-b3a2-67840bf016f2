package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    void deleteLessonByLessonid(Long lessonid);
    
    List<Lesson> getLessonByCourseid(Long courseid);
}


