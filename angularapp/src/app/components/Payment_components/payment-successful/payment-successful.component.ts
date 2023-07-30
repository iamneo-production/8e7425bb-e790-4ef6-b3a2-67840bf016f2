import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-payment-successful',
  templateUrl: './payment-successful.component.html',
  styleUrls: ['./payment-successful.component.css']
})
export class PaymentSuccessfulComponent implements OnInit {
  constructor(private router: Router) { }


  ngOnInit(): void {

  }

  //to redirect to courses page after payment
  GoToCoursesPage() {
    this.router.navigate(['/studentCourses']);
  }

}
