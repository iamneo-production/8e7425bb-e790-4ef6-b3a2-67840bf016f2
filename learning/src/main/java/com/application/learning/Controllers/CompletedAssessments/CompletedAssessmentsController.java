package main.java.com.application.learning.Controllers.CompletedAssessments;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.application.learning.Models.CompletedAssessments.CompletedAssessmentsModel;
import main.java.com.application.learning.Services.CompletedAssessments.CompletedAssessmentsService;

@RestController
@RequestMapping("/assessment")
public class CompletedAssessmentsController {

    private final CompletedAssessmentsService assessmentsService;

    
    public CompletedAssessmentsController(CompletedAssessmentsService assessmentsService) {
        this.assessmentsService = assessmentsService;
    }

    @GetMapping("/data")
    public List<CompletedAssessmentsModel> assessment(){

        return assessmentsService.getAllAssessments();

    }

}
