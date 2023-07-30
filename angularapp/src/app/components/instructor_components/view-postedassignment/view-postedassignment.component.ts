import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Assignment, AssignmentQuestion } from 'src/app/models/assignment';
import { AssignmentService } from 'src/app/services/assignment.service';

@Component({
  selector: 'app-view-postedassignment',
  templateUrl: './view-postedassignment.component.html',
  styleUrls: ['./view-postedassignment.component.css']
})

export class ViewPostedassignmentComponent {
  assignmentId: number = 0
  questions: AssignmentQuestion[] = []
  assignment: Assignment = {
    id: 0,
    courseId: 0,
    instructorId: 0,
    assignmentName: '',
    postedDate: new Date(),
    dueDate: new Date()
  }

  constructor(private assignmentService: AssignmentService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.assignmentId = +params.get('id')!;
      this.getAssignmentQuestion()
      this.getAssignment()
    });
  }

  //to get assignment
  getAssignment() {
    this.assignmentService.getbyId(this.assignmentId).subscribe((response: Assignment) => {
      this.assignment = response;
    })
  }

  //to get assignment question
  getAssignmentQuestion() {
    this.assignmentService.getAssignmentQuestions(this.assignmentId).subscribe((response: AssignmentQuestion[]) => {
      this.questions = response
    })
  }

  //to redirect to assignments page on back button click
  onback() {
    this.router.navigate(['/allAssignments'])
  }
}
