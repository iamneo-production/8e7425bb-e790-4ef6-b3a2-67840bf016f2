import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  //to check and return the status of availability of user id in local storage
  IsLoggedIn(){
    return !!localStorage.getItem('id');
  }
}
