import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Payment } from "../models/payment";


@Injectable({
    providedIn: 'root'
})

export class PaymentService {


    constructor(private httpClient: HttpClient) {}
    
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

    //to post new payment details
    public makePayment(payment: Payment): Observable<any> {
        return this.httpClient.post(`${this.baseUrl}/payment`, payment);
    }

    //to get all payment details by using id
    public getPaymentList(id: number): Observable<Payment[]> {
        return this.httpClient.get<Payment[]>(`${this.baseUrl}/payment/detail/${id}`);
    }
}
