package com.example.springapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Question;
import com.example.springapp.repository.QuestionRepository;

@RestController
@RequestMapping("/questions")
@CrossOrigin("http://localhost:4200")


public class QuestionController {
    @Autowired
    public QuestionRepository questionRepository;
    @PostMapping("/addquestion")
    public List<Question> addQuestion(@RequestBody Question receivedQuestion){
        questionRepository.save(receivedQuestion);
        return questionRepository.findQuestionsbyCourseId(receivedQuestion.getCourseId());
    }

    @GetMapping("/getquestion/{id}")
    public Question getQuestion(@PathVariable("id") Long id){
        return questionRepository.findById(id).get();
    }

     @GetMapping("/allquestions/{courseId}")
    public List<Question> getAllbyId(@PathVariable("courseId") Long courseId){
        return questionRepository.findQuestionsbyCourseId(courseId);
    }
}