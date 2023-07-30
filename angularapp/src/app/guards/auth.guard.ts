import { Injectable } from "@angular/core";
import {  CanActivate, Router } from "@angular/router";
import { AuthService } from "../services/auth.service";

@Injectable({
  providedIn:'root'
})

export class AuthGuard implements CanActivate{

  constructor(private auth: AuthService, private router:Router){}

  //to activate the guard on checking the login status
  canActivate() {
      if(this.auth.IsLoggedIn()){
        return true;
      }
      this.router.navigate(['login']);
      alert("User not logged in")
      return false;
  }
}