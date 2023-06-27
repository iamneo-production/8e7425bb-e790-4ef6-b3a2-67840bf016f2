package main.java.com.application.learning.Repository.CompletedAssessments;

import java.util.List;

import org.springframework.stereotype.Repository;


import main.java.com.application.learning.Models.CompletedAssessments.CompletedAssessmentsModel;

@Repository
public class CompletedAssessmentsRepository {

    public List<CompletedAssessmentsModel> getAllAssessments() {

        return List.of(
                new CompletedAssessmentsModel(
                        "Full Stack Web Development", "Quiz",
                        "25 June 2023",
                        "Create a RESTful API with CRUD functionality using MongoDB and Mongoose."),

                new CompletedAssessmentsModel(
                        "Full Stack Web Development", "Quiz",
                        "25 June 2023",
                        "Create a simple web page using HTML and CSS."),

                new CompletedAssessmentsModel(
                        "Full Stack Web Development", "Quiz",
                        "25 June 2023",
                        "Build a responsive navigation menu using JavaScript."),

                new CompletedAssessmentsModel(
                        "Full Stack Web Development", "Quiz",
                        "25 June 2023",
                        "Set up a local development environment with Node.js and Express."),

                new CompletedAssessmentsModel(
                        "Full Stack Web Development", "Quiz",
                        "25 June 2023",
                        "Implement user authentication using Passport.js."),

                new CompletedAssessmentsModel(
                        "Full Stack Web Development", "Quiz",
                        "25 June 2023",
                        "Build a front-end framework using React."),

                new CompletedAssessmentsModel(
                        "Full Stack Web Development", "Quiz",
                        "25 June 2023",
                        "Integrate Stripe payments into your application."),

                new CompletedAssessmentsModel(
                        "Full Stack Web Development", "Quiz",
                        "25 June 2023",
                        "Deploy your application to a cloud-based hosting service like Heroku or AWS."));

    }

}
