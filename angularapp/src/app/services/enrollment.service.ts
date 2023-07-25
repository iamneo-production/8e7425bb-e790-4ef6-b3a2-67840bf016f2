import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Enrollment } from '../models/enrollment';
import { Course } from '../models/course';


@Injectable({
  providedIn: 'root'
})
export class EnrollmentService {

  private baseUrl = 'https://8080-cbbdbceccaaadcdddffaedcbcabfdfafdade.project.examly.io';
  
  constructor(private http: HttpClient) {
  }

  //to get enrollments by course id
  public getEnrollmentsByCourseId(courseId: number): Observable<Enrollment[]> {
    let url = `${this.baseUrl}/enrollment/getEnrollmentsByCourseId/${courseId}`;
    return this.http.get<Enrollment[]>(url)
  }

  //to get enrollments by user id
  public getEnrollmentsByUserId(): Observable<Enrollment[]> {
    let userId = localStorage.getItem('id')
    let url = `${this.baseUrl}/enrollment/getEnrollments/${userId}`;
    return this.http.get<Enrollment[]>(url)
  }

  //to get enrolled courses by user id
  public getEnrolledCoursesByUserId(): Observable<Course[]> {
    let userId = localStorage.getItem('id')
    let url = `${this.baseUrl}/enrollment/getEnrolledCourses/${userId}`;
    return this.http.get<Course[]>(url)
  }

  //to delete enrollment by id
  public deleteEnrollmentById(id: any): Observable<any> {
    let url = `${this.baseUrl}/enrollment/deleteById/${id}`;
    return this.http.delete(url)
  }

  //to delete enrollments by course id
  public deleteAllEnrollmentsByCourseId(courseId: any): Observable<any> {
    let url = `${this.baseUrl}/enrollment/deleteAllByCourseId/${courseId}`;
    return this.http.delete(url)
  }

  //to post new enrollment
  public addNewEnrollment(enrollment: Enrollment): Observable<any> {
    let url = `${this.baseUrl}/enrollment`;
    return this.http.post(url, enrollment)
  }
}
