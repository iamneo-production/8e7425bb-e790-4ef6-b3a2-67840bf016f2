import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Userinfo } from 'src/app/models/userinfo';
import { UserService } from 'src/app/services/user.service';
import { passwordmatch } from 'src/app/validators/passwordmatch.validator';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  type = "password";
  isText = false;
  signupForm!: FormGroup;
  submitted = false;
  userinfo: Userinfo = {
    email: null,
    username: null,
    education: null,
    occupation: null,
    domain: null,
    organization: null,
    totaltime: 0
  };
  constructor(private fb: FormBuilder, private signupservice: UserService, private router: Router) {
  }

  ngOnInit(): void {
    this.signupForm = this.fb.group({
      email: new FormControl(null, [Validators.required, Validators.pattern("^[a-z0-9]+@gmail\.com$")]),
      role: new FormControl(null, Validators.required),
      password: new FormControl(null, [Validators.required, Validators.minLength(8)]),
      confirmPassword: new FormControl(null)
    },
      {
        validators: passwordmatch
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

  //to add new user
  signup() {
    console.log(this.signupForm.value);
    this.signupservice.SignupUser(this.signupForm.value).subscribe(data => {
      alert("Sign-up sucessfull, Please Login!");
      this.userinfo.email = data.email
      this.userinfo.occupation = data.role
      this.adduserinfo();
      this.router.navigate(['/login']);
    }, error => alert("Account already exists"))
  }

  //to add additional user info
  adduserinfo() {
    this.signupservice.adduserinfo(this.userinfo).subscribe(data => {
      console.log(data)
    });
  }
  
}
