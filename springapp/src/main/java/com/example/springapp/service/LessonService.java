package com.example.springapp.service;

import com.example.springapp.model.Lesson;

import java.util.List;

public interface LessonService {

    
    public Lesson addLesson(Lesson lesson);

    public List<Lesson> findAllLessons();

    public Lesson updateLesson(Lesson lesson);

    public void deleteLesson(Long lessonId);

    public List<Lesson> getLessonByCourseId(Long courseId);

    public Lesson getLessonById(Long lessonId);
}

