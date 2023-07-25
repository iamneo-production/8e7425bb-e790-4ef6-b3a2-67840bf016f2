import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  users: any | undefined;
  type = "password";
  isText = false;
  loginForm!: FormGroup;
  submitted = false;

  constructor(private fb: FormBuilder, private loginService: UserService, private router: Router) {
  }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.pattern("^[a-z0-9]+@gmail\.com$")]],
      password: ['', [Validators.required, Validators.minLength(8)]]
    })
  }

  //to view the password typed
  onpassclick() {
    this.isText = !this.isText;
    if (this.isText) {
      this.type = "text";
    }
    else {
      this.type = "password";
    }
  }

  //to login the existing user by validating their credentials
  login() {
    this.loginService.loginUser(this.loginForm).subscribe(data => {
      localStorage.setItem('role', data.role);
      localStorage.setItem('id', data.id);
      localStorage.setItem('email', data.email);
      localStorage.setItem('loginTime', new Date().toISOString());
      if (data.role === 'student') {
        this.router.navigate(['/studentHome'])
      }
      else if (data.role === 'instructor') {
        this.router.navigate(['/instructorHome'])
      }
    }, error => {
      alert("incorrect Username/password");
    }
    );
  }
  
}
