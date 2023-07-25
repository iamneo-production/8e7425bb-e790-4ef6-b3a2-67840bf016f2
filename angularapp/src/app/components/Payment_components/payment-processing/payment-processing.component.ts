import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-payment-processing',
  templateUrl: './payment-processing.component.html',
  styleUrls: ['./payment-processing.component.css']
})
export class PaymentProcessingComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
    setTimeout(() => {
      this.router.navigate(['/PaymentSuccessfull']); // Replace '/success' with the desired destination route
    }, 5000); // 5000 milliseconds = 5 seconds
  }
  
}
