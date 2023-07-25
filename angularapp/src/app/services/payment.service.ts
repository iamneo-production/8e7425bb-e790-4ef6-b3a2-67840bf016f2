import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Payment } from "../models/payment";


@Injectable({
    providedIn: 'root'
})

export class PaymentService {


    constructor(private httpClient: HttpClient) {}
    
    private baseUrl = 'https://8080-cbbdbceccaaadcdddffaedcbcabfdfafdade.project.examly.io';

    //to post new payment details
    public makePayment(payment: Payment): Observable<any> {
        return this.httpClient.post(`${this.baseUrl}`, payment);
    }

    //to get all payment details by using id
    public getPaymentList(id: number): Observable<Payment[]> {
        return this.httpClient.get<Payment[]>(`${this.baseUrl}/detail/${id}`);
    }
}
