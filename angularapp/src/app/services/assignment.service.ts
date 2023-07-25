import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Assignment, AssignmentQuestion, CompletedAssignmentData } from '../models/assignment';

@Injectable({
  providedIn: 'root'
})
export class AssignmentService {

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


  constructor(private http:HttpClient) { }

  //to post new assignment
  public postassignment(assignment:Assignment):Observable<Assignment>{
    let url = `${this.baseUrl}/assignment/addAssignment`
    return this.http.post<Assignment>(url,assignment)
  }

  //to post questions for a particular assignment
  public addquestions(question:AssignmentQuestion):Observable<AssignmentQuestion>{
    let url = `${this.baseUrl}/assignmentQuestion/addQuestion`
    return this.http.post<AssignmentQuestion>(url,question)
  }

  //to get assignments of particular course
  public getAssignment():Observable<Assignment[]>{
    let courseId = localStorage.getItem('courseId')
    let url =`${this.baseUrl}/assignment/getbyCourseId/${courseId}`
    return this.http.get<Assignment[]>(url)
  }

  //to get assignment questions of particular assignment
  public getAssignmentQuestions(assignmentId:number):Observable<AssignmentQuestion[]>{
    let url = `${this.baseUrl}/assignmentQuestion/getbyAssignmentId/${assignmentId}`
    return this.http.get<AssignmentQuestion[]>(url)
  }

  //to get assignment by id
  public getbyId(id:number):Observable<Assignment>{
    let url = `${this.baseUrl}/assignment/getbyId/${id}`
    return this.http.get<Assignment>(url)
  }

  //to post completed assignment data
  public addCompletedAssignment(assignmentData:CompletedAssignmentData):Observable<CompletedAssignmentData>{
    let url = `${this.baseUrl}/completed/add`
    return this.http.post<CompletedAssignmentData>(url,assignmentData)
  }

  //to get all completed assignments of a user
  public getCompletedAssignments():Observable<CompletedAssignmentData[]>{
    let userId = localStorage.getItem('id')
    let url = `${this.baseUrl}/completed/getbyuserId/${userId}`
    return this.http.get<CompletedAssignmentData[]>(url)
  }

  // to get completed assignment data by assignment id
  public getCompletedAssignmentsbyId(assignmentId:number):Observable<CompletedAssignmentData[]>{
    let url = `${this.baseUrl}/completed/getbyassignmentId/${assignmentId}`
    return this.http.get<CompletedAssignmentData[]>(url)
  }
}

