import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Assignment, CompletedAssignmentData } from 'src/app/models/assignment';
import { AssignmentService } from 'src/app/services/assignment.service';

@Component({
  selector: 'app-view-assignment',
  templateUrl: './view-assignment.component.html',
  styleUrls: ['./view-assignment.component.css']
})

export class ViewAssignmentComponent {

  assignments: Assignment[] = []
  completedAssignments: CompletedAssignmentData[] = []
  assignmentId = 0;

  constructor(private router: Router, private assignmentService: AssignmentService) { }

  ngOnInit() {
    this.getCompletedAssignmentsData();
  }

  //to get all assignments
  getAssignments() {
    this.assignmentService.getAssignment().subscribe((response: Assignment[]) => {
      this.assignments = this.filterAssignments(response)
      const secondListAssignmentIds = this.completedAssignments.map(item => item.assignmentId);
      this.assignments = this.assignments.filter(item => !secondListAssignmentIds.includes(item.id))
    })
  }

  //to get completed assignment data
  getCompletedAssignmentsData() {
    this.assignmentService.getCompletedAssignments().subscribe((response: CompletedAssignmentData[]) => {
      this.completedAssignments = this.filterDataByCourseId(response)
      this.getAssignments();
    })
  }

  //to filter courses by course id
  filterDataByCourseId(data: CompletedAssignmentData[]) {
    let courseId = Number(localStorage.getItem('courseId'))
    return data.filter((item) => item.courseId === courseId);
  }

  //to filter assignments
  filterAssignments(assignments: Assignment[]): Assignment[] {
    const currentDate = new Date();
    currentDate.setHours(0, 0, 0, 0);
    return assignments.filter((assignment) => {
      const dueDate = new Date(assignment.dueDate);
      dueDate.setHours(0, 0, 0, 0);
      return currentDate.getTime() <= dueDate.getTime();
    });
  }

  //to get assignment id
  getAssignmentId(id: number) {
    this.assignmentId = id;
  }


  //to redirect to lessons page on back button click
  onback() {
    this.router.navigate(['/lessons'])
  }

  //to redirect to test page
  gotoTestPage() {
    this.router.navigate(['/takeAssignment', this.assignmentId])
  }

  //to toggle colors of selected button
  color1 = 'selected'
  color2 = 'notselected'
  onClick() {
    let col = this.color1
    this.color1 = this.color2
    this.color2 = col
  }
}
