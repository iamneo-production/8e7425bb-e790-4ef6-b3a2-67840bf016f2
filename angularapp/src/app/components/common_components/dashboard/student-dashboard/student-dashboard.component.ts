import { Component } from '@angular/core';
import { Chart, registerables } from 'node_modules/chart.js';
import { Userinfo } from 'src/app/models/userinfo';
import { CompletedAssignmentData } from 'src/app/models/assignment';
import { Course } from 'src/app/models/course';
import { AssignmentService } from 'src/app/services/assignment.service';
import { EnrollmentService } from 'src/app/services/enrollment.service';
import { UserService } from 'src/app/services/user.service';
Chart.register(...registerables);

@Component({
  selector: 'app-student-dashboard',
  templateUrl: './student-dashboard.component.html',
  styleUrls: ['./student-dashboard.component.css']
})
export class StudentDashboardComponent {
  userinfo: Userinfo = {
    email: null,
    username: null,
    education: null,
    occupation: null,
    domain: null,
    organization: null,
    totaltime: 0
  };
  enrolledCourses: Course[] = []
  lastFourCourses: Course[] = [];
  assignments: CompletedAssignmentData[] = [];

  constructor(private userinfoService: UserService, private enrollmentService: EnrollmentService, private assignmentService: AssignmentService) { }

  ngOnInit() {

    this.getinfo();
    this.getEnrolledCourses();
    this.getAssignments();
  }

  //to get enrolled courses
  getEnrolledCourses() {
    this.enrollmentService.getEnrolledCoursesByUserId().subscribe((response: Course[]) => {
      this.enrolledCourses = response
      console.log(this.enrolledCourses)
      this.lastFourCourses = this.enrolledCourses.slice(-4).reverse();
    })
  }

  //to get assignments for calculating average assignment score
  getAssignments() {
    this.assignmentService.getCompletedAssignments().subscribe((response: CompletedAssignmentData[]) => {
      const totalMarks = response.reduce((sum, obj) => sum + obj.marksObtained, 0);
      const averageMarks = totalMarks / response.length;
      const remainingMarks = 100 - averageMarks
      this.renderChart(averageMarks, remainingMarks);
    })
  }

  //chart to be rendered for displaying assignment progress
  renderChart(averageMarks: number, remainingMarks: number) {
    const myChart = new Chart("donut", {
      type: 'doughnut',
      data: {
        labels: [
          'Deviation',
          'Average Obtained'

        ],
        datasets: [{
          label: 'In Percentage(%)',
          data: [remainingMarks, averageMarks],
          backgroundColor: [
            '#808080',
            '#5e17eb'
          ],
          hoverOffset: 4
        }]

      },
      options:
      {
        maintainAspectRatio: false,
        plugins: {
          legend: {
            display: false
          }
        },
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });
  }

  // to get student info
  getinfo() {
    this.userinfoService.getuserinfo().subscribe(data => {
      this.userinfo = data
      console.log(this.userinfo);
    }, error => alert('error getting value'))
  }

  // to update student info
  updateinfo(username: string, education: string, organization: string, domain: string) {
    this.userinfo.username = username
    this.userinfo.education = education
    this.userinfo.organization = organization
    this.userinfo.domain = domain
    console.log(this.userinfo)
    this.userinfoService.updateuserinfo(this.userinfo).subscribe(data => {
      this.userinfo = data;
    }, error => { alert("error in updating") })
  }

}
