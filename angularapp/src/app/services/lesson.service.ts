import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Lesson } from '../models/lesson';

@Injectable({
  providedIn: 'root'
})
export class LessonServiceImpl {

  private baseUrl = 'https://8080-cbbdbceccaaadcdddffaedcbcabfdfafdade.project.examly.io';

  constructor(private http: HttpClient) { }

  //to get all lessons
  public getLessons(): Observable<Lesson[]> {
    let url = `${this.baseUrl}/lesson`
    return this.http.get<Lesson[]>(url);
  }

  //to post new lesson
  public addLessons(lesson: Lesson): Observable<Lesson> {
    let url = `${this.baseUrl}/lesson/add`
    return this.http.post<Lesson>(url, lesson);
  }

  //to update lesson
  public updateLessons(lesson: Lesson): Observable<Lesson> {
    let url = `${this.baseUrl}/lesson/update`
    return this.http.put<Lesson>(url, lesson);
  }

  //to delete lesson
  public deleteLessons(lessonId: number): Observable<any> {
    let url = `${this.baseUrl}/lesson/delete/${lessonId}`;
    return this.http.delete<any>(url);
  }

  //to delete all lessons by course id
  public getLessonByCourseId(courseId: number): Observable<any> {
    let url = `${this.baseUrl}/lesson/${courseId}`;
    return this.http.get<any>(url);
  }

  //to get specific lesson by id
  public getLessonById(lessonId: number): Observable<Lesson> {
    let url = `${this.baseUrl}/lesson/getbyid/${lessonId}`;
    return this.http.get<Lesson>(url);
  }
}
