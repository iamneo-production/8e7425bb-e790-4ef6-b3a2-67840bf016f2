package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.CompletedAssignments;
import com.example.springapp.repository.CompletedAssignmentRepository;


@Service
public class CompletedAssignmentService {
    @Autowired
    public CompletedAssignmentRepository completedAssignmentRepository;

    public CompletedAssignments addCompletedAssignment(CompletedAssignments completedAssignments){
        return completedAssignmentRepository.save(completedAssignments);
    }

    public List<CompletedAssignments> getAllbycourseId(Long courseId){
        return completedAssignmentRepository.findallBycourseId(courseId);
    }

    public List<CompletedAssignments> getAllbyuserId(Long userId){
        return completedAssignmentRepository.findallByuserId(userId);
    }

    public List<CompletedAssignments> getAllbyinstructorId(Long instructorId){
        return completedAssignmentRepository.findallByInstructorId(instructorId);
    }

    public List<CompletedAssignments> getAllbyassignmentId(Long assignmentId){
        return completedAssignmentRepository.findallByAssignmentId(assignmentId);
    }
}
