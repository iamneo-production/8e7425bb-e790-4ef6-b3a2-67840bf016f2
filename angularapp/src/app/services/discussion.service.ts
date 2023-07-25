import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Question } from '../models/question';
import { Reply } from '../models/reply';

@Injectable({
  providedIn: 'root'
})
export class DiscussionService {

  private baseUrl = 'http://localhost:8080';

  constructor(private httpClient: HttpClient) { }
 
//to get discussion by id
 getQuestion():Observable<Question>{
  let questionId = localStorage.getItem('questionId')
  let url = `${this.baseUrl}/questions/getquestion/${questionId}`;
  return this.httpClient.get<Question>(`${url}`);
}

//to get all discussions
 getAllquestions():Observable<Question[]>{
  let courseId = localStorage.getItem('courseId');
  let url = `${this.baseUrl}/questions/allquestions/${courseId}`;
    return this.httpClient.get<Question[]>(`${url}`);
 }
 
 //to get all replies
 getAllReplies():Observable<Reply[]>{
  let questionId = localStorage.getItem('questionId')
  let url = `${this.baseUrl}/reply/getAllreplies/${questionId}`;
    return this.httpClient.get<Reply[]>(`${url}`);
 }

 //to post new discussion
 postQuestion(postQuestion:Question):Observable<Question[]>{
  let url = `${this.baseUrl}/questions/addquestion`;
    return this.httpClient.post<Question[]>(`${url}`,postQuestion);
 }
 
 //to post new reply
 postReply(postReply:Reply):Observable<Reply[]>{
  let url = `${this.baseUrl}/reply/addreply`;
    return this.httpClient.post<Reply[]>(`${url}`,postReply);
 }
}
