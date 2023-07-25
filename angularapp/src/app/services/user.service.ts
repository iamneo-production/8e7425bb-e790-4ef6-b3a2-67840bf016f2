import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { Userinfo } from '../models/userinfo';

@Injectable({
  providedIn: 'root'
})
export class UserService {

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

  constructor(private httpClient: HttpClient) { }

  //to login existing user
  loginUser(loginForm: FormGroup): Observable<any> {
    let url = `${this.baseUrl}/users/login`;
    return this.httpClient.post(url, loginForm.value);
  }

  //to signup new user
  SignupUser(signupForm: FormGroup): Observable<any> {
    let url = `${this.baseUrl}/users/register`;
    return this.httpClient.post(url, signupForm);
  }

  //to update user password
  ForgotUser(forgotpasswordForm: FormGroup): Observable<any> {
    let url = `${this.baseUrl}/users`
    return this.httpClient.put(url, forgotpasswordForm);
  }

  //to delete the user
  deleteUser(): Observable<any> {
    let id = localStorage.getItem('id');
    let url = `${this.baseUrl}/users?id=${id}`;
    return this.httpClient.delete(url);
  }

  //to get the user-info
  getuserinfo(): Observable<Userinfo> {
    let id = localStorage.getItem('email');
    let url = `${this.baseUrl}/userinfo/get/${id}`;
    return this.httpClient.get<Userinfo>(url);
  }

  //to update the user-info
  updateuserinfo(userinfo: Userinfo): Observable<Userinfo> {
    let url = `${this.baseUrl}/userinfo/update`;
    return this.httpClient.put<Userinfo>(url, userinfo);
  }

  //to post new user-info
  adduserinfo(userinfo: Userinfo): Observable<Userinfo> {
    let url = `${this.baseUrl}/userinfo/add`;
    return this.httpClient.post<Userinfo>(url, userinfo);
  }
}
