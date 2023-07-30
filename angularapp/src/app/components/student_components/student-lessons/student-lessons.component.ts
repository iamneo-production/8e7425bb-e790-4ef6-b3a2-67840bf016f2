import { Location } from '@angular/common';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Course } from 'src/app/models/course';
import { Lesson } from 'src/app/models/lesson';
import { CourseServiceImpl } from 'src/app/services/course.service';
import { LessonServiceImpl } from 'src/app/services/lesson.service';

@Component({
  selector: 'app-student-lessons',
  templateUrl: './student-lessons.component.html',
  styleUrls: ['./student-lessons.component.css']
})
export class StudentLessonsComponent {
  public lessons: Lesson[] = [];
  public course: Course = {
    courseId: 0,
    courseName: '',
    courseDescription: '',
    instructorId: 0
  };
  courseId: number = 0;

  constructor(private lessonService: LessonServiceImpl, private courseService: CourseServiceImpl, private router: Router, private location: Location) { }

  ngOnInit(): void {
    this.courseId = Number(localStorage.getItem('courseId'))
    this.getLessonsByCourseId();
    this.getCourse();
  }

  //to get lessons by course id
  public getLessonsByCourseId(): void {
    this.lessonService.getLessonByCourseId(this.courseId).subscribe((response: Lesson[]) => {
      this.lessons = response
    })
  }

  //to get courses
  getCourse() {
    this.courseService.getCourseByCourseId(this.courseId).subscribe((response: Course) => {
      this.course = response;
      console.log(this.course)
    })
  }

  //to redirect to lesson description 
  public showlessondescription(lessonId?: number): void {
    this.router.navigate(['lessondescription', lessonId]);
  }

  //to redirect to courses page on back button click
  onback() {
    this.router.navigate(['/studentCourses'])
  }
}
