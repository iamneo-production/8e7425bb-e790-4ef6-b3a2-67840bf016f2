import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Course } from 'src/app/models/course';
import { Lesson } from 'src/app/models/lesson';
import { CourseServiceImpl } from 'src/app/services/course.service';
import { LessonServiceImpl } from 'src/app/services/lesson.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-instructor-lessons',
  templateUrl: './instructor-lessons.component.html',
  styleUrls: ['./instructor-lessons.component.css']
})
export class InstructorLessonsComponent {
  public lessons: Lesson[] = [];
  public course: Course = {
    courseId: 0,
    courseName: '',
    courseDescription: '',
    instructorId: 0
  };
  public addLesson: Lesson = {
    lessonId: 0,
    lessonName: '',
    lessonDescription: '',
    courseId: Number(localStorage.getItem('courseId'))
  }
  public editLesson: Lesson = {
    lessonId: 0,
    lessonName: '',
    lessonDescription: '',
    courseId: 0
  };
  public courseId: number = 0;
  lessonId: number = 0;

  constructor(private router: Router,
    private courseService: CourseServiceImpl,
    private lessonService: LessonServiceImpl,
    private route: ActivatedRoute,
    private location: Location) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.courseId = +params.get('courseId')!;
      this.getLessonsByCourseId(this.courseId);
    });
    this.getCourse();
  }

  //to get course by id
  getCourse() {
    this.courseService.getCourseByCourseId(this.courseId).subscribe((response: Course) => {
      this.course = response;
      console.log(this.course)
    })
  }

  //to get lessons by id
  getLessonsByCourseId(courseId: number) {
    this.lessonService.getLessonByCourseId(courseId).subscribe((response: Lesson[]) => {
      this.lessons = response;
      console.log(this.lessons)
    })
  }

  //to get lesson by id
  getLesson(lessonId: number) {
    this.lessonService.getLessonById(lessonId).subscribe((response: Lesson) => {
      this.editLesson = response
      console.log(this.editLesson)
    })
  }

  //to get lesson id
  getLessonId(lessonId: number) {
    this.lessonId = lessonId;
  }

  //to redirect to courses page on back button click
  onback() {
    this.router.navigate(['/instructorCourses'])
  }

  //to add lesson
  onAddLesson() {
    this.lessonService.addLessons(this.addLesson).subscribe((response: Lesson) => {
      this.getLessonsByCourseId(this.courseId)
      this.addLesson = {
        lessonId: 0,
        lessonName: '',
        lessonDescription: '',
        courseId: Number(localStorage.getItem('courseId'))
      }
    })
  }

  //to edit lesson
  onEditLesson() {
    this.lessonService.updateLessons(this.editLesson).subscribe((response: Lesson) => {
      this.getLessonsByCourseId(this.courseId)
    })
  }

  //to delete lesson
  onDeleteLesson() {
    this.lessonService.deleteLessons(this.lessonId).subscribe(Response => {
      this.getLessonsByCourseId(this.courseId)
    })
  }
}
