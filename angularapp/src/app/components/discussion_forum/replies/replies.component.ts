import { Component } from '@angular/core';
import { Question } from 'src/app/models/question';
import { Reply } from 'src/app/models/reply';
import { DiscussionService } from 'src/app/services/discussion.service';

@Component({
  selector: 'app-replies',
  templateUrl: './replies.component.html',
  styleUrls: ['./replies.component.css']
})

export class RepliesComponent {
  repliescount: number = 0;
  addReply: string = '';
  replierName: any = localStorage.getItem('email');
  role: any = localStorage.getItem('role');
  replies: Reply[] = [];
  question: Question = {
    id: 0,
    courseId: 0,
    userName: '',
    question: ''
  };
  postReply: Reply = {
    id: 0,
    questionId: Number(localStorage.getItem('questionId')),
    replierName: this.replierName,
    role: this.role,
    reply: ''
  };

  constructor(private questionService: DiscussionService) { }

  ngOnInit(): void {
    this.getQuestion();
    this.getReplies();
  }

  //to get the particular discussion
  getQuestion() {
    this.questionService.getQuestion().subscribe(data => {
      this.question = data;
    })
  }

  //to get the replies for that particular discussion
  getReplies() {
    this.questionService.getAllReplies().subscribe(data => {
      this.replies = data;
      this.replies.reverse();
      this.repliescount = this.replies.length;
    })
  }

  //to post the reply
  onsave() {
    this.postReply.reply = this.addReply;
    console.log(this.postReply);
    this.questionService.postReply(this.postReply).subscribe(data => {
      console.log(data);
      this.replies = data;
      this.replies.reverse();
      this.repliescount = this.replies.length;
    })
  }

}
