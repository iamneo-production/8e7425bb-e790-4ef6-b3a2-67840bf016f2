import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Assignment, AssignmentQuestion, CompletedAssignmentData } from 'src/app/models/assignment';
import { AssignmentService } from 'src/app/services/assignment.service';

@Component({
  selector: 'app-take-assignment',
  templateUrl: './take-assignment.component.html',
  styleUrls: ['./take-assignment.component.css']
})
export class TakeAssignmentComponent {
  assignment: AssignmentQuestion[] = [];
  selectedOptions: string[] = [];
  score: number = 0;
  isTestCompleted: boolean = false;
  percentage: number = 0;
  assignmentId: number = 0;
  assignmentDetail: Assignment = {
    id: 0,
    courseId: 0,
    instructorId: 0,
    assignmentName: '',
    postedDate: new Date(),
    dueDate: new Date()
  }
  completedAssignment: CompletedAssignmentData = {
    id: 0,
    assignmentId: 0,
    instructorId: 0,
    courseId: 0,
    userId: 0,
    marksObtained: 0,
    assignmentName: ''
  }

  constructor(private route: ActivatedRoute, private assignmentService: AssignmentService, private router: Router) { }

  ngOnInit(): void {
    this.score = 0;
    this.route.paramMap.subscribe(params => {
      this.assignmentId = +params.get('assignmentId')!;
      this.getAssignmentQuestions();
      this.getAssignment();
    });
  }

  //to get all assignments
  getAssignment() {
    this.assignmentService.getbyId(this.assignmentId).subscribe((response: Assignment) => {
      this.assignmentDetail = response
    })
  }

  //to update index on option change
  optionChange = (index: number, option: string) => {
    this.selectedOptions[index] = option;
    console.log(this.selectedOptions);
  };

  //to validate empty fields
  hasEmptyFields = () => {
    for (const item of this.selectedOptions) {
      if (item === null || item === undefined) {
        return true;
      }
    }
    return false;
  };

  //redirect to assignment page with a small delay of 3000ms
  redirectToOtherPageWithDelay() {
    const delayInMilliseconds = 3000;
    setTimeout(() => {
      this.router.navigate(['/viewAssignments']);
    }, delayInMilliseconds);
  }

  //to handle the submit function
  handleSubmit(): void {
    for (let i = 0; i < this.selectedOptions.length; i++) {
      console.log(
        this.assignment[i].answer, ' ', this.selectedOptions[i]);
      if (this.assignment[i].answer === this.selectedOptions[i]) {
        this.score += 1;
      }
    }
    this.percentage = Number((this.score / this.selectedOptions.length * 100).toFixed(2));
    this.isTestCompleted = true;
    this.completedAssignment.assignmentId = this.assignmentId;
    this.completedAssignment.instructorId = this.assignmentDetail.instructorId;
    this.completedAssignment.assignmentName = this.assignmentDetail.assignmentName;
    this.completedAssignment.userId = Number(localStorage.getItem('id'));
    this.completedAssignment.courseId = Number(localStorage.getItem('courseId'));
    this.completedAssignment.marksObtained = this.percentage
    this.saveAssignmentScore();
  }

  //to save assignment score
  saveAssignmentScore() {
    this.assignmentService.addCompletedAssignment(this.completedAssignment).subscribe((response: CompletedAssignmentData) => {
      this.redirectToOtherPageWithDelay();
    })

  }

  //to get assignment questions
  getAssignmentQuestions() {
    this.assignmentService.getAssignmentQuestions(this.assignmentId).subscribe((response: AssignmentQuestion[]) => {
      this.assignment = response
    })
  }

}
