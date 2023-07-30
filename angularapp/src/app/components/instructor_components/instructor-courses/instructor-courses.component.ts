import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Course } from 'src/app/models/course';
import { CourseServiceImpl } from 'src/app/services/course.service';
import { Location } from '@angular/common';
import { EnrollmentService } from 'src/app/services/enrollment.service';


@Component({
  selector: 'app-instructor-courses',
  templateUrl: './instructor-courses.component.html',
  styleUrls: ['./instructor-courses.component.css']
})
export class InstructorCoursesComponent implements OnInit {
  public instructorId = localStorage.getItem('id')
  public course: Course[] = [];
  public editCourses: Course = {
    courseId: 0,
    courseName: '',
    courseDescription: '',
    instructorId: 0
  };
  public deleteCourses: Course = {
    courseId: 0,
    courseName: '',
    courseDescription: '',
    instructorId: 0
  };

  constructor(private courseService: CourseServiceImpl, private enrollmentService: EnrollmentService, private router: Router, private location: Location) { }

  ngOnInit() {
    this.getCourses();
  }

  //to get posted courses
  public getCourses(): void {
    this.courseService.getCoursebyInstructorId().subscribe(
      (response: Course[]) => {
        this.course = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  //to add a new course
  public onAddCourses(addForm: NgForm): void {
    var addCourse: Course = {
      courseId: 0,
      courseName: '',
      courseDescription: '',
      instructorId: 0
    }
    addCourse = addForm.value
    addCourse.instructorId = Number(this.instructorId)
    this.courseService.addCourses(addCourse).subscribe(
      (response: Course) => {
        console.log(response);
        this.getCourses();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  // to update new course
  public onUpdateCourses(course: Course): void {
    this.courseService.updateCourses(course).subscribe(
      (response: Course) => {
        console.log(response);
        this.getCourses();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  //to delete enrollments if course is deleted
  public deleteEnrollments(courseId: number): void {
    this.enrollmentService.deleteAllEnrollmentsByCourseId(courseId).subscribe(response => {
    }, error => { alert(error) })
  }

  //to delete course
  public onDeleteCourses(courseId: number): void {
    this.courseService.deleteCourses(courseId).subscribe(
      (response: void) => {
        this.getCourses();
        this.deleteEnrollments(courseId);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  //to show lessons
  public showlessons(courseId?: number): void {
    this.router.navigate(['/instructorLessons', courseId]);
    localStorage.setItem('courseId', courseId + '');
  }

  //to open add course modal
  openAddModal(course: null, mode: string): void {
    const button = document.getElementById('onAddCourses');
    if (button != null) {
      button.style.display = 'block';
    }
  }

  //to open edit course modal
  openEditModal(course: Course, mode: string): void {
    this.editCourses = course;
    const button = document.getElementById('onEditCourses');
    if (button != null) {
      button.style.display = 'block';
    }
  }
  
  //to open delete course modal
  openDeleteModal(course: Course, mode: string): void {
    this.deleteCourses = course;
    const button = document.getElementById('onDeleteCourses');
    if (button != null) {
      button.style.display = 'block';
    }
  }

  //to close add course modal
  closeAddModal() {
    const button = document.getElementById('onAddCourses');
    if (button != null) {
      button.style.display = 'none';
    }
  }

  //to close edit course modal
  closeEditModal() {
    const button = document.getElementById('onEditCourses');
    if (button != null) {
      button.style.display = 'none';
    }
  }

  //to close delete course modal
  closeDeleteModal() {
    const button = document.getElementById('onDeleteCourses');
    if (button != null) {
      button.style.display = 'none';
    }
  }

  //to redirect to home page on back button click
  onback() {
    this.router.navigate(['/instructorHome'])
  }

}
