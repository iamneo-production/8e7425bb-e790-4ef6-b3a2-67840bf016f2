import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Payment } from 'src/app/models/payment';
import { PaymentService } from 'src/app/services/payment.service';

@Component({
  selector: 'app-payment-report',
  templateUrl: './payment-report.component.html',
  styleUrls: ['./payment-report.component.css']
})
export class PaymentReportComponent {
  payments: Payment[] = [];
  user_id: number = Number(localStorage.getItem('id'));

  constructor(private paymentService: PaymentService, private router: Router) { }

  ngOnInit(): void {
    this.getPayments(this.user_id);
  }

  //to get payment details
  private getPayments(id: number) {
    this.paymentService.getPaymentList(id).subscribe(data => {
      this.payments = data;
    })
  }

  //to redirect to home page on back button click
  onback() {
    this.router.navigate(['/studentHome'])
  }
}
