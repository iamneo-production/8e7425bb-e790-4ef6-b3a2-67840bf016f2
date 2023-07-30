package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Lesson;
import com.example.springapp.repository.LessonRepository;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService{

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public Lesson addLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public List<Lesson> findAllLessons() {
        return (List<Lesson>) lessonRepository.findAll();
    }

    public Lesson updateLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public void deleteLesson(Long lessonId) {
        lessonRepository.deleteLessonByLessonId(lessonId);
    }

    public List<Lesson> getLessonByCourseId(Long courseId) {
        return lessonRepository.getLessonByCourseId(courseId);
    }

    public Lesson getLessonById(Long lessonId){
        return lessonRepository.findById(lessonId).get();
    }
    
}


