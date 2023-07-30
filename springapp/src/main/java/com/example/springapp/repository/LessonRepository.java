package com.example.springapp.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Lesson;

@Transactional
@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    void deleteLessonByLessonId(Long lessonId);
    
    List<Lesson> getLessonByCourseId(Long courseId);

}


