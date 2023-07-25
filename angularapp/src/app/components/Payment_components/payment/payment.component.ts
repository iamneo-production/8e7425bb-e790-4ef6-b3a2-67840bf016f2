import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Payment } from 'src/app/models/payment';
import { PaymentService } from 'src/app/services/payment.service';
import { Enrollment } from 'src/app/models/enrollment';
import { EnrollmentService } from 'src/app/services/enrollment.service';

declare var window: any;
@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  course_id: number = 0;
  pay: Payment = {
    id: 0,
    userId: 0,
    amount: 0,
    courseId: 0,
    date: new Date()
  }

  constructor(private enrollmentService: EnrollmentService, private router: Router, private route: ActivatedRoute, private paymentService: PaymentService) { }

  ngOnInit(): void {
    this.course_id = this.route.snapshot.params['id'];
    this.pay.amount = 200;
    this.pay.courseId = this.course_id;
    this.pay.date = new Date();
    this.pay.userId = Number(localStorage.getItem('id'))
  }

  @ViewChild('myForm') form?: NgForm;

  //to save payment details
  savePayment() {
    this.paymentService.makePayment(this.pay).subscribe((data: any) => {
      console.log(data);
      this.saveEnrollment();
    },
      (error: any) => console.log(error));
  }

  //to enroll user after payment
  saveEnrollment() {
    let enrollment: Enrollment = {
      id: 0,
      courseId: this.course_id,
      userId: Number(localStorage.getItem('id'))
    }
    this.enrollmentService.addNewEnrollment(enrollment).subscribe(response => {
      this.GoToPaymentProcessing();
    }, error => alert('error in enrolling course'))

  }

  //to redirect to processing screen after payment
  GoToPaymentProcessing() {
    this.router.navigateByUrl('PaymentProcessing');
  }

  //to implement save payment on button click
  OnSubmit() {
    this.savePayment();
  }

  //to redirect to courses page on back button click
  onback() {
    this.router.navigate(['/studentCourses'])
  }

}
