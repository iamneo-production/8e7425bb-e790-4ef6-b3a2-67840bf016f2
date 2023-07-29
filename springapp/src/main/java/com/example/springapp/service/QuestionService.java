package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Question;
import com.example.springapp.repository.QuestionRepository;

@Service
public class QuestionService {

    @Autowired
    public QuestionRepository questionRepository;

    public Question addQuestion(Question question){
        return questionRepository.save(question);
    }

    public List<Question> getAllByCourseId(Long courseId){
        return questionRepository.findQuestionsbyCourseId(courseId);
    }

    public Question getById(Long id){
        return questionRepository.findById(id).get();
    }
    
}