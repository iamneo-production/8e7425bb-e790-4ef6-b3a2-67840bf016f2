import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Course } from '../models/course';

@Injectable({
  providedIn: 'root'
})
export class CourseServiceImpl {

  //santhosh
  private baseUrl = 'https://8080-cbbdbceccaaadcdddffaedcbcabfdfafdade.project.examly.io';

  //ramesh
  //private baseUrl = 'https://8080-febcaabfefeacfadcdddffaedcbcabfdfafdade.project.examly.io';

  //rithick
  //private baseUrl = 'https://8080-ccfbbdadfbadcdddffaedcbcabfdfafdade.project.examly.io';

  //oviya
  //private baseUrl = 'https://8080-bfbbbeacbadcdddffaedcbcabfdfafdade.project.examly.io';

  //joshika
  //private baseUrl = 'https://8080-fdfedfdaaaacfedbadcdddffaedcbcabfdfafdade.project.examly.io';

  //sumanth
  //private baseUrl = 'https://8080-daeacaadbcfaeadcdddffaedcbcabfdfafdade.project.examly.io';

  //mrinal
  //private baseUrl = 'https://8080-fbbfbccabebadcdddffaedcbcabfdfafdade.project.examly.io';

  //muskan
  //private baseUrl = 'https://8080-ddefcefdabfbdadcdddffaeeaeaadbdbabf.project.examly.io';
  
  //rishik
  //private baseUrl = 'https://8080-caccdedfdbdccefeadcdddffaedcbcabfdfafdade.project.examly.io';

  constructor(private http: HttpClient) { }

  //to get all courses
  public getCourses(): Observable<Course[]> {
    let url = `${this.baseUrl}/course`
    return this.http.get<Course[]>(url);
  }

  //to post new course
  public addCourses(course: Course): Observable<Course> {
    let url = `${this.baseUrl}/course`
    return this.http.post<Course>(url, course);
  }

  //to update course
  public updateCourses(course: Course): Observable<Course> {
    let url = `${this.baseUrl}/course/update`
    return this.http.put<Course>(url, course);
  }

  //to delete course
  public deleteCourses(courseId: number): Observable<any> {
    let url = `${this.baseUrl}/course/delete/${courseId}`
    return this.http.delete<any>(url);
  }

  //to get courses by instrucctor id
  public getCoursebyInstructorId(): Observable<Course[]> {
    let instructorId = localStorage.getItem('id');
    let url = `${this.baseUrl}/course/instructor/${instructorId}`;
    return this.http.get<Course[]>(url);
  }

  //to get specific course by id
  public getCourseByCourseId(courseId: number): Observable<any> {
    let url = `${this.baseUrl}/course/${courseId}`;
    return this.http.get<any>(url);
  }

}
