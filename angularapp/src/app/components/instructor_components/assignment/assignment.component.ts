import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Assignment, AssignmentQuestion } from 'src/app/models/assignment';
import { AssignmentService } from 'src/app/services/assignment.service';


@Component({
  selector: 'app-assignment',
  templateUrl: './assignment.component.html',
  styleUrls: ['./assignment.component.css']
})

export class AssignmentComponent {
  title: string = "";
  assignment: Assignment = {
    id: 0,
    courseId: Number(localStorage.getItem('courseId')),
    instructorId: Number(localStorage.getItem('id')),
    assignmentName: '',
    postedDate: new Date(),
    dueDate: new Date()
  }
  Questions: string[] = new Array(4);
  assignmentQuestion: AssignmentQuestion[] = []
  currentIndex: number = -1;

  constructor(private assignmentservice: AssignmentService, private router: Router) { }

  ngOnInit(): void {
    this.increment();
  }

  trackByFn(index: number, obj: any) {
    return index;
  }


  increment() {
    this.assignmentQuestion.push(new AssignmentQuestion('', ['', '', '', ''], ''));
    this.currentIndex = this.assignmentQuestion.length - 1;
  }

  //to display question
  showQuestion(x: number) {
    this.currentIndex = x;
  }

  // to validate empty fields
  validateEmptyFields(ind: number) {
    let tempOptions = this.assignmentQuestion[ind].options;
    let res = false;
    tempOptions.forEach(option => {
      if (option === '') {
        res = true;
      }
    });
    if (this.assignmentQuestion[ind].answer === '') {
      res = true;
    }
    if (this.assignmentQuestion[ind].question === '') {
      res = true;
    }
    return res;
  }

  //to get option indexes
  getOption(a: number) {
    return String.fromCharCode(97 + a).toUpperCase();
  }

  //to be implemented on submit click
  handleSubmit() {
    this.assignment.assignmentName = this.title;
    this.assignment.dueDate.setDate(this.assignment.postedDate.getDate() + 5);
    this.assignmentservice.postassignment(this.assignment).subscribe((response: Assignment) => {
      this.assignment = response
      this.addQuestion()
      this.onback()
    })
    this.currentIndex = -1
  }

  //to add the questions
  addQuestion() {
    for (let index = 0; index < this.assignmentQuestion.length; index++) {
      const element = this.assignmentQuestion[index];
      element.assignmentId = this.assignment.id
      this.assignmentservice.addquestions(element).subscribe((response: AssignmentQuestion) => {
        console.log(response)
      })
    }
  }

  //to validate all fields in input box
  onValid() {
    let allQuestions = this.assignmentQuestion
    let res = false;
    if (this.title === '') {
      res = true
    }
    allQuestions.forEach(assignmentQuestion => {
      if (assignmentQuestion.question === '') {
        res = true
      }
      if (assignmentQuestion.answer === '') {
        res = true
      }
      let tempOptions = assignmentQuestion.options
      tempOptions.forEach(option => {
        if (option === '') {
          res = true;
        }
      });
    })
    return res;
  }

  //to redirect to assignments page on back button click
  onback() {
    this.router.navigate(['/allAssignments'])
  }
}
