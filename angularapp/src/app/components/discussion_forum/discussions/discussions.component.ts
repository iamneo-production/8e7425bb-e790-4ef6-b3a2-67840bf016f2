import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Question } from 'src/app/models/question';
import { DiscussionService } from 'src/app/services/discussion.service';
import { Location } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-discussions',
  templateUrl: './discussions.component.html',
  styleUrls: ['./discussions.component.css']
})

export class DiscussionsComponent {
  userName: any = localStorage.getItem('email');
  role: string = localStorage.getItem('role')!;
  courseId: number = Number(localStorage.getItem('courseId'))
  postQuestion: Question = {
    id: 0,
    courseId: Number(localStorage.getItem('courseId')),
    userName: this.userName,
    question: ''
  };
  questions: Question[] = [];
  addQuestion: string = '';

  constructor(private questionService: DiscussionService, private fb: FormBuilder, private location: Location, private router: Router) { }

  ngOnInit(): void {
    this.getQuestions();
  }

  //to get all the questions
  getQuestions() {
    this.questionService.getAllquestions().subscribe(data => {
      this.questions = data;
      this.questions.reverse();
    })
  }

  //to get the specific question id on click
  onClick(question: Question) {
    localStorage.setItem('questionId', question.id + '');
  }

  //to redirect to lessons page
  onback() {
    if (this.role === 'instructor') {
      this.router.navigate(['/instructorLessons', this.courseId])
    }
    else if (this.role === 'student') {
      this.router.navigate(['/lessons'])
    }
  }

  //to post new discussion
  onsave() {
    this.postQuestion.question = this.addQuestion;
    this.questionService.postQuestion(this.postQuestion).subscribe(data => {
      console.log(data);
      this.questions = data;
      this.questions.reverse();
    })
    this.addQuestion = '';
  }

}
