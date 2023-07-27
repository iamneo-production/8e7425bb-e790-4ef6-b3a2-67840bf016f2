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
//santhosh
// @CrossOrigin(origins = "https://8081-cbbdbceccaaadcdddffaedcbcabfdfafdade.project.examly.io")

//ramesh
//@CrossOrigin(origins = "https://8081-febcaabfefeacfadcdddffaedcbcabfdfafdade.project.examly.io")

//rithick
//@CrossOrigin(origins = "https://8081-ccfbbdadfbadcdddffaedcbcabfdfafdade.project.examly.io")

//oviya
//@CrossOrigin(origins = "https://8081-bfbbbeacbadcdddffaedcbcabfdfafdade.project.examly.io")

//joshika
//@CrossOrigin(origins = "https://8081-fdfedfdaaaacfedbadcdddffaedcbcabfdfafdade.project.examly.io")

//sumanth
//@CrossOrigin(origins = "https://8081-daeacaadbcfaeadcdddffaedcbcabfdfafdade.project.examly.io")

//mrinal
//@CrossOrigin(origins = "https://8081-fbbfbccabebadcdddffaedcbcabfdfafdade.project.examly.io")

//muskan
//@CrossOrigin(origins = "https://8081-ddefcefdabfbdadcdddffaeeaeaadbdbabf.project.examly.io")

//rishik
@CrossOrigin(origins = "https://8081-caccdedfdbdccefeadcdddffaedcbcabfdfafdade.project.examly.io")

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