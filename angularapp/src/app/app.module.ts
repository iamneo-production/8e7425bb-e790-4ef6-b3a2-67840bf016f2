import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/common_components/navbar/navbar.component';
import { AboutComponent } from './components/common_components/about/about.component';
import { HelpnsupportComponent } from './components/common_components/helpnsupport/helpnsupport.component';
import { HomepageComponent } from './components/common_components/homepage/homepage.component';
import { InstructorDashboardComponent } from './components/common_components/dashboard/instructor-dashboard/instructor-dashboard.component';
import { StudentDashboardComponent } from './components/common_components/dashboard/student-dashboard/student-dashboard.component';
import { DiscussionsComponent } from './components/discussion_forum/discussions/discussions.component';
import { RepliesComponent } from './components/discussion_forum/replies/replies.component';
import { LoginComponent } from './components/login_and_signup/login/login.component';
import { SignupComponent } from './components/login_and_signup/signup/signup.component';
import { ForgotpasswordComponent } from './components/login_and_signup/forgotpassword/forgotpassword.component';
import { AllAssignmentsComponent } from './components/instructor_components/all-assignments/all-assignments.component';
import { AssignmentComponent } from './components/instructor_components/assignment/assignment.component';
import { AssignmentReportComponent } from './components/instructor_components/assignment-report/assignment-report.component';
import { InstructorCoursesComponent } from './components/instructor_components/instructor-courses/instructor-courses.component';
import { InstructorLessonsComponent } from './components/instructor_components/instructor-lessons/instructor-lessons.component';
import { ViewPostedassignmentComponent } from './components/instructor_components/view-postedassignment/view-postedassignment.component';
import { PaymentComponent } from './components/Payment_components/payment/payment.component';
import { PaymentDetailComponent } from './components/Payment_components/payment-detail/payment-detail.component';
import { PaymentReportComponent } from './components/Payment_components/payment-report/payment-report.component';
import { PaymentProcessingComponent } from './components/Payment_components/payment-processing/payment-processing.component';
import { PaymentSuccessfulComponent } from './components/Payment_components/payment-successful/payment-successful.component';
import { SummaryComponent } from './components/Payment_components/summary/summary.component';
import { LessondescriptionComponent } from './components/student_components/lessondescription/lessondescription.component';
import { StudentCoursesComponent } from './components/student_components/student-courses/student-courses.component';
import { StudentLessonsComponent } from './components/student_components/student-lessons/student-lessons.component';
import { TakeAssignmentComponent } from './components/student_components/take-assignment/take-assignment.component';
import { ViewAssignmentComponent } from './components/student_components/view-assignment/view-assignment.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AboutComponent,
    HelpnsupportComponent,
    HomepageComponent,
    InstructorDashboardComponent,
    StudentDashboardComponent,
    DiscussionsComponent,
    RepliesComponent,
    LoginComponent,
    SignupComponent,
    ForgotpasswordComponent,
    AllAssignmentsComponent,
    AssignmentComponent,
    AssignmentReportComponent,
    InstructorCoursesComponent,
    InstructorLessonsComponent,
    ViewPostedassignmentComponent,
    PaymentComponent,
    PaymentDetailComponent,
    PaymentReportComponent,
    PaymentProcessingComponent,
    PaymentSuccessfulComponent,
    SummaryComponent,
    LessondescriptionComponent,
    StudentCoursesComponent,
    StudentLessonsComponent,
    TakeAssignmentComponent,
    ViewAssignmentComponent
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
