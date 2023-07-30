import { Component } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { passwordmatch } from 'src/app/validators/passwordmatch.validator';

@Component({
  selector: 'app-forgotpassword',
  templateUrl: './forgotpassword.component.html',
  styleUrls: ['./forgotpassword.component.css']
})
export class ForgotpasswordComponent {
  type = "password";
  isText = false;
  forgotpasswordForm!: FormGroup;
  submitted = false;

  constructor(private fb: FormBuilder, private signupservice: UserService, private router: Router) {
  }

  ngOnInit(): void {
    this.forgotpasswordForm = this.fb.group({
      email: new FormControl(null, [Validators.required, Validators.pattern("^[a-z0-9]+@gmail\.com$")]),
      password: new FormControl(null, [Validators.required, Validators.minLength(8)]),
      confirmPassword: new FormControl(null)
    },
      {
        validators: passwordmatch
      })
  }

  //to display the password typed 
  onpassclick() {
    this.isText = !this.isText;
    if (this.isText) {
      this.type = "text";
    }
    else {
      this.type = "password";
    }
  }

  //to reset the password
  forgotpass() {
    console.log(this.forgotpasswordForm.value);

    this.signupservice.ForgotUser(this.forgotpasswordForm.value).subscribe(data => {
      alert("Reset successfull, Please login with new credentials")
      this.router.navigate(['/login']);
    }, error => alert("Account doesn't exists"))
  }

}
