package com.example.springapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Question;
import com.example.springapp.service.QuestionService;

@RestController
@RequestMapping("/questions")
//santhosh
@CrossOrigin(origins = "https://8081-cbbdbceccaaadcdddffaedcbcabfdfafdade.project.examly.io")

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
//@CrossOrigin(origins = "https://8081-caccdedfdbdccefeadcdddffaedcbcabfdfafdade.project.examly.io")

public class QuestionController {
    @Autowired
    public QuestionService questionService;

    @PostMapping("/addquestion")
    public ResponseEntity<List<Question>> addQuestion(@RequestBody Question receivedQuestion){
    try {
        questionService.addQuestion(receivedQuestion);
        List<Question> questions =  questionService.getAllByCourseId(receivedQuestion.getCourseId());
            return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
        }
        catch (Exception e) {
            throw new RuntimeException("Error is posting question", e);
        }
    }

    @GetMapping("/getquestion/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable("id") Long id){
        try {
        Question questions =  questionService.getById(id);
        return new ResponseEntity<Question>(questions, HttpStatus.OK);
        }
        catch (Exception e) {
            throw new RuntimeException("No such question with this ID", e);
        }  
    }


    @GetMapping("/allquestions/{courseId}")
    public ResponseEntity<List<Question>> getAllbyId(@PathVariable("courseId") Long courseId){
        try {
            List<Question> questions =  questionService.getAllByCourseId(courseId);
            return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
        }
        catch (Exception e) {
            throw new RuntimeException("No such questions with this course ID", e);
        }  
    }
}