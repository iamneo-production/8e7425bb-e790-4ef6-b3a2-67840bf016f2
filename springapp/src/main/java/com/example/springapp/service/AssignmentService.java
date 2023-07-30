package com.example.springapp.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Assignment;
import com.example.springapp.repository.AssignmentRepository;

@Service
public class AssignmentService {
    @Autowired
    public AssignmentRepository assignmentRepository;

    public List<Assignment> getAllAssignmentsbyInstructorId(Long instructorId){
        return assignmentRepository.findAssignmentsByInstructorId(instructorId);
    }

    public Assignment getById(Long id){
        return assignmentRepository.findById(id).get();
    }
    
    public List<Assignment> getAllAssignmentsbyCourseId(Long courseId){
        return assignmentRepository.findAssignmentsByCourseId(courseId);
    }

    public Assignment createAssignment(Assignment assignment){
        return assignmentRepository.save(assignment);
    }

    public void deleteAssignment(Long id){
        assignmentRepository.deleteById(id);
    }


}
