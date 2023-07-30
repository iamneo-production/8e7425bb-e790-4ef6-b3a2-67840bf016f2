import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { Lesson } from 'src/app/models/lesson';
import { LessonServiceImpl } from 'src/app/services/lesson.service';

@Component({
  selector: 'app-lessondescription',
  templateUrl: './lessondescription.component.html',
  styleUrls: ['./lessondescription.component.css']
})
export class LessondescriptionComponent implements OnInit {
  public lesson: Lesson = {
    lessonId: 0,
    lessonName: '',
    lessonDescription: '',
    courseId: 0
  };
  public lessonId: number = 0;

  constructor(private lessonService: LessonServiceImpl, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.lessonId = +params.get('lessonId')!;
      this.getLessonByLessonId(this.lessonId);
    });
  }

  //redirect to lessons page on back button click
  onback() {
    this.router.navigate(['/lessons'])
  }

  //to get lesson by lesson id
  public getLessonByLessonId(lessonId: number): void {
    this.lessonService.getLessonById(lessonId).subscribe(
      (response: Lesson) => {
        this.lesson = response;
      },
      (error: any) => {
        console.error(error);
      }
    );
  }
}
