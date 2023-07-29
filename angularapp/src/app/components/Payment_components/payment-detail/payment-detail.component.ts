import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-payment-detail',
  templateUrl: './payment-detail.component.html',
  styleUrls: ['./payment-detail.component.css']
})
export class PaymentDetailComponent {
  courseId: number = 0;
  transactionId: number = 0;

  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.courseId = parseInt(this.route.snapshot.paramMap.get('courseId')!);
    this.transactionId = parseInt(this.route.snapshot.paramMap.get('paymentId')!)
  }

  //to redirect to payment report page on back button click
  onback() {
    this.router.navigate(['/paymentReport'])
  }

}
