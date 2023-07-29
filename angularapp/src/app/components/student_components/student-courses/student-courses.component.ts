import { Location } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Course } from 'src/app/models/course';
import { Enrollment } from 'src/app/models/enrollment';
import { CourseServiceImpl } from 'src/app/services/course.service';
import { EnrollmentService } from 'src/app/services/enrollment.service';

@Component({
  selector: 'app-student-courses',
  templateUrl: './student-courses.component.html',
  styleUrls: ['./student-courses.component.css']
})
export class StudentCoursesComponent {

  public courses: Course[] = [];
  public enrollments: Enrollment[] = [];
  public enrolledCourses: Course[] = [];
  public filteredEnrolledCourses: Course[] = [];
  public filteredCourses: Course[] = [];
  searchText = ''
  unEnrollId: number | undefined = 0;

  constructor(private courseService: CourseServiceImpl, private router: Router, private location: Location, private enrollmentService: EnrollmentService) { }

  ngOnInit() {
    this.getCourses();
    this.getenrollmentsbyuserid();
    this.getenrolledcoursesbyuserid();
  }

  //to get all courses
  public getCourses(): void {
    this.courseService.getCourses().subscribe(
      (response: Course[]) => {
        this.courses = response;
        this.filteredCourses = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  //to get enrollments by id
  getenrollmentsbyuserid() {
    this.enrollmentService.getEnrollmentsByUserId().subscribe((response: Enrollment[]) => {
      this.enrollments = response;
    })
  }

  //to get enrolled courses by user id
  getenrolledcoursesbyuserid() {
    this.enrollmentService.getEnrolledCoursesByUserId().subscribe((response: Course[]) => {
      this.enrolledCourses = response;
      this.filteredEnrolledCourses = response;
    })
  }

  //to redirect to homepage on backbutton click
  onback() {
    this.router.navigate(['/studentHome']);
  }

  //to filter enrolled courses
  isEnrolled(course: Course): boolean {
    return this.enrolledCourses.some((enrolledCourse) => enrolledCourse.courseId === course.courseId);
  }

  //to get unenroll id
  getunenrollId(courseId: number) {
    let userId: number = Number(localStorage.getItem('id'))
    let matchedEnrollment = this.enrollments.find((enrollment) => {
      return enrollment.courseId === courseId && enrollment.userId === userId;
    });
    this.unEnrollId = matchedEnrollment?.id
  }

  //to unenroll course
  unEnroll() {
    this.enrollmentService.deleteEnrollmentById(this.unEnrollId).subscribe(response => {
      this.getCourses();
      this.getenrollmentsbyuserid();
      this.getenrolledcoursesbyuserid();
    }, error => alert('error unenrolling course'))
  }

  //to redirect to summary page
  goToSummary(courseId: number) {
    this.router.navigate(['/SummaryPage', courseId])
  }

  //to store course id
  saveCourseId(courseId: number) {
    localStorage.setItem('courseId', courseId + '')
  }

  //search functionality implementation
  onSearch() {
    if (this.searchText.trim() === '') {
      this.filteredEnrolledCourses = this.enrolledCourses;
      this.filteredCourses = this.courses;

    } else {
      this.filteredEnrolledCourses = this.enrolledCourses.filter(course =>
        course.courseName.toLowerCase().includes(this.searchText.toLowerCase())
      );

      this.filteredCourses = this.courses.filter(course =>
        course.courseName.toLowerCase().includes(this.searchText.toLowerCase())
      );
    }
  }
}
