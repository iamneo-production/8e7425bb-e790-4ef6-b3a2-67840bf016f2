import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CompletedAssignmentData } from 'src/app/models/assignment';
import { AssignmentService } from 'src/app/services/assignment.service';

@Component({
  selector: 'app-assignment-report',
  templateUrl: './assignment-report.component.html',
  styleUrls: ['./assignment-report.component.css']
})
export class AssignmentReportComponent {
  completedAssignment: CompletedAssignmentData[] = [];
  assignmentId: number = 0

  constructor(private assignmentService: AssignmentService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.assignmentId = +params.get('id')!;
      this.assignmentService.getCompletedAssignmentsbyId(this.assignmentId).subscribe((response: CompletedAssignmentData[]) => {
        this.completedAssignment = response
      })
    });
  }

  //to redirect to assignments page on back button click
  onback() {
    this.router.navigate(['/allAssignments'])
  }

}
