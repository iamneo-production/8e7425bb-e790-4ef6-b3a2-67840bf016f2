package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Assignment;
import com.example.springapp.service.AssignmentService;

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

@RequestMapping("/assignment")
public class AssignmentController {

    @Autowired
    public AssignmentService assignmentService;

    @PostMapping("/addAssignment")
    public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment assignment){
        Assignment createdAssignment =  assignmentService.createAssignment(assignment);
        return new ResponseEntity<Assignment>(createdAssignment, HttpStatus.OK);
    }

    @GetMapping("/getbyCourseId/{courseId}")
    public ResponseEntity<List<Assignment>> getAssignmentsByCourseId(@PathVariable("courseId") Long CourseId){
        List<Assignment> assignments = assignmentService.getAllAssignmentsbyCourseId(CourseId);
        return new ResponseEntity<>(assignments,HttpStatus.OK);
    }

    @GetMapping("getbyId/{id}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable("id") Long id){
        Assignment assignment = assignmentService.getById(id);
        return new ResponseEntity<Assignment>(assignment, HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Long id){
        assignmentService.deleteAssignment(id);
        return "Deleted";
    }
}
