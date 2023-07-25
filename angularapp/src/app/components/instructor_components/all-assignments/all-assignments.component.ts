import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Assignment } from 'src/app/models/assignment';
import { AssignmentService } from 'src/app/services/assignment.service';

@Component({
  selector: 'app-all-assignments',
  templateUrl: './all-assignments.component.html',
  styleUrls: ['./all-assignments.component.css']
})
export class AllAssignmentsComponent {
  assignments: Assignment[] = []
  assignmentId = 0;

  constructor(private router: Router, private assignmentService: AssignmentService) { }

  ngOnInit() {
    this.getAssignments();
  }

  //to get all assignments
  getAssignments() {
    this.assignmentService.getAssignment().subscribe((response: Assignment[]) => {
      this.assignments = response
      console.log(this.assignments)
    })
  }

  //to redirect to specific assignment details page
  viewAssignment(id: number) {
    this.router.navigate(['/viewPostedassignment', id])
  }

  //to redirect to specific assignment report page
  viewAssignmentReport(id: number) {
    this.router.navigate(['/assignmentReport', id])
  }

  //to redirect to lessons page on back button click
  onback() {
    let courseId = localStorage.getItem('courseId')
    this.router.navigate(['/instructorLessons', courseId])
  }

}
