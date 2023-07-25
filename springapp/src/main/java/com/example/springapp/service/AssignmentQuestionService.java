package com.example.springapp.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.AssignmentQuestion;
import com.example.springapp.repository.AssignmentQuestionRepository;

@Service
public class AssignmentQuestionService {
    @Autowired
    public AssignmentQuestionRepository assignmentQuestionRepository;

    public List<AssignmentQuestion> getAllAssignmentQuestionsByAssignmentId(Long assignmentId){
        return assignmentQuestionRepository.findAssignmentQuestionsByAssignmentId(assignmentId);
    }

    public AssignmentQuestion addQuestion(AssignmentQuestion assignmentQuestion){
        return assignmentQuestionRepository.save(assignmentQuestion);
    }
}
