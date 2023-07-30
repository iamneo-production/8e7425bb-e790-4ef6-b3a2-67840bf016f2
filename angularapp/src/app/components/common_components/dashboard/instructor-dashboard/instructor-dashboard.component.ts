import { Component } from '@angular/core';
import { Userinfo } from 'src/app/models/userinfo';
import { Course } from 'src/app/models/course';
import { Enrollment } from 'src/app/models/enrollment';
import { CourseServiceImpl } from 'src/app/services/course.service';
import { EnrollmentService } from 'src/app/services/enrollment.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-instructor-dashboard',
  templateUrl: './instructor-dashboard.component.html',
  styleUrls: ['./instructor-dashboard.component.css']
})

export class InstructorDashboardComponent {
  userinfo: Userinfo = {
    email: null,
    username: null,
    education: null,
    occupation: null,
    domain: null,
    organization: null,
    totaltime: 0
  };
  courses: Course[] = []
  lastFourCourses: Course[] = []
  enrollments: Enrollment[] = []
  count = 0;
  learnersCount = 0

  constructor(private userinfoService: UserService, private courseService: CourseServiceImpl, private enrollmentService: EnrollmentService) { }

  ngOnInit() {
    this.getinfo();
    this.getCourses();
  }

  //to get instructor-info
  getinfo() {
    this.userinfoService.getuserinfo().subscribe(data => {
      this.userinfo = data
      console.log(this.userinfo);
    }, error => alert('error getting value'))
  }

  //to update instructor-info
  updateinfo(username: string, education: string, organization: string, domain: string) {
    this.userinfo.username = username
    this.userinfo.education = education
    this.userinfo.organization = organization
    this.userinfo.domain = domain
    console.log(this.userinfo)
    this.userinfoService.updateuserinfo(this.userinfo).subscribe(data => {
      this.userinfo = data;
      console.log(this.enrollments)
    }, error => { alert("error in updating") })
  }

  //to get courses posted
  getCourses() {
    this.courseService.getCoursebyInstructorId().subscribe((response: Course[]) => {
      this.courses = response
      console.log(this.courses)
      this.lastFourCourses = this.courses.slice(-4).reverse();
      console.log(this.lastFourCourses)
      this.getEnrollmentsCount()
    })
  }

  //to get learners count
  countUniqueUsers(enrollmentList: Enrollment[]): number {
    const uniqueUsers = new Set<number>();
    for (const enrollment of enrollmentList) {
      const userId = enrollment.userId;
      uniqueUsers.add(userId);
    }
    return uniqueUsers.size;
  }

  //to get enrollments count
  async getEnrollmentsCount() {
    for (let index = 0; index < this.courses.length; index++) {
      const course = this.courses[index];
      const response = await this.enrollmentService.getEnrollmentsByCourseId(course.courseId).toPromise();
      if (response !== undefined) {
        this.count += response.length;
        for (let i = 0; i < response.length; i++) {
          this.enrollments.push(response[i]);
        }
      }
    }
    this.learnersCount = this.countUniqueUsers(this.enrollments)
  }

}