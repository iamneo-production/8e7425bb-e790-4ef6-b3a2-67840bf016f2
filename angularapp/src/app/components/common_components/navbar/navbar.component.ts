import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Userinfo } from 'src/app/models/userinfo';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  icons = "bi bi-three-dots navbtn";
  username = localStorage.getItem('email');
  role = localStorage.getItem('role');
  userinfo: Userinfo = {
    email: localStorage.getItem('email'),
    username: null,
    education: null,
    occupation: null,
    domain: null,
    organization: null,
    totaltime: 0
  };

  constructor(private router: Router, private deleteService: UserService) {
  }

  //to redirect user according to the role
  onUserClick() {
    if (this.role === 'instructor') {
      this.router.navigate(['instructorHome'])
    }
    else if (this.role === 'student') {
      this.router.navigate(['studentHome'])
    }
  }

  //to toggle collapse button icon
  onclick() {
    if (this.icons === "bi bi-three-dots navbtn") {
      this.icons = "bi bi-x navbtn";
    }
    else if (this.icons === "bi bi-x navbtn") {
      this.icons = "bi bi-three-dots navbtn";
    }
  }

  //to logout the user
  logout() {
    let logoutTime = new Date().toISOString();
    let loginTime = localStorage.getItem('loginTime')!;
    const hoursSpent = Math.abs(new Date(logoutTime).getTime() - new Date(loginTime).getTime()) / 3600000;
    const hoursSpentFormatted = hoursSpent.toFixed(2);
    this.deleteService.getuserinfo().subscribe(data => {
      console.log(data);
      this.userinfo = data;
      this.userinfo.totaltime += Number(hoursSpentFormatted);
      this.deleteService.updateuserinfo(this.userinfo).subscribe(data => {
        console.log(data)
      })
    });
    localStorage.clear();
    this.router.navigate(['/login']);
  }

  //to delete the user account
  deleteUser() {
    this.deleteService.deleteUser().subscribe(data => {
      localStorage.clear();
      alert("Account deleted successfully");
      this.router.navigate(['/login']);
    }, error => {
      alert("error deleting the account");
    })
  }

}
