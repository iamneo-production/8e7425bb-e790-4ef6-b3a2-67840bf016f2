package main.java.com.application.learning.Services.CompletedAssessments;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.application.learning.Models.CompletedAssessments.CompletedAssessmentsModel;
import main.java.com.application.learning.Repository.CompletedAssessments.CompletedAssessmentsRepository;

@Service
public class CompletedAssessmentsService {
        private final CompletedAssessmentsRepository completedAssessmentsRepository;

        
        @Autowired
        public CompletedAssessmentsService(CompletedAssessmentsRepository completedAssessmentsRepository) {
                this.completedAssessmentsRepository = completedAssessmentsRepository;
        }


        public List<CompletedAssessmentsModel> getAllAssessments() {
                return completedAssessmentsRepository.getAllAssessments();
        }
}
