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

import com.example.springapp.model.CompletedAssignments;
import com.example.springapp.service.CompletedAssignmentService;

@RestController
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

@RequestMapping("/completed")
public class CompletedAssignmentController {
    @Autowired
    public CompletedAssignmentService completedAssignmentService;

    @PostMapping("/add")
    public ResponseEntity<CompletedAssignments> addCompletedAssignments(@RequestBody CompletedAssignments completedAssignments){
        CompletedAssignments addedAssignment = completedAssignmentService.addCompletedAssignment(completedAssignments);
        return new ResponseEntity<CompletedAssignments>(addedAssignment,HttpStatus.OK);
    }

    @GetMapping("/getbyuserId/{userId}")
    public ResponseEntity<List<CompletedAssignments>> getbyuserId(@PathVariable("userId") Long userId){
        List<CompletedAssignments> completedAssignments = completedAssignmentService.getAllbyuserId(userId);
        return new ResponseEntity<List<CompletedAssignments>>(completedAssignments, HttpStatus.OK);
    }
    
    @GetMapping("/getbycourseId/{courseId}")
    public ResponseEntity<List<CompletedAssignments>> getbycourseId(@PathVariable("courseId") Long courseId){
        List<CompletedAssignments> completedAssignments = completedAssignmentService.getAllbycourseId(courseId);
        return new ResponseEntity<List<CompletedAssignments>>(completedAssignments, HttpStatus.OK);
    }

    @GetMapping("/getbyinstructorId/{instructorId}")
    public ResponseEntity<List<CompletedAssignments>> getbyinstructorId(@PathVariable("instructorId") Long instructorId){
        List<CompletedAssignments> completedAssignments = completedAssignmentService.getAllbyinstructorId(instructorId);
        return new ResponseEntity<List<CompletedAssignments>>(completedAssignments, HttpStatus.OK);
    }

    @GetMapping("/getbyassignmentId/{assignmentId}")
    public ResponseEntity<List<CompletedAssignments>> getbyassignmentId(@PathVariable("assignmentId") Long assignmentId){
        List<CompletedAssignments> completedAssignments = completedAssignmentService.getAllbyassignmentId(assignmentId);
        return new ResponseEntity<List<CompletedAssignments>>(completedAssignments, HttpStatus.OK);
    }

}
