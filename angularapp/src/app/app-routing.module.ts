import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PaymentDetailComponent } from './components/Payment_components/payment-detail/payment-detail.component';
import { PaymentProcessingComponent } from './components/Payment_components/payment-processing/payment-processing.component';
import { PaymentReportComponent } from './components/Payment_components/payment-report/payment-report.component';
import { PaymentSuccessfulComponent } from './components/Payment_components/payment-successful/payment-successful.component';
import { PaymentComponent } from './components/Payment_components/payment/payment.component';
import { SummaryComponent } from './components/Payment_components/summary/summary.component';
import { AboutComponent } from './components/common_components/about/about.component';
import { InstructorDashboardComponent } from './components/common_components/dashboard/instructor-dashboard/instructor-dashboard.component';
import { StudentDashboardComponent } from './components/common_components/dashboard/student-dashboard/student-dashboard.component';
import { HelpnsupportComponent } from './components/common_components/helpnsupport/helpnsupport.component';
import { HomepageComponent } from './components/common_components/homepage/homepage.component';
import { DiscussionsComponent } from './components/discussion_forum/discussions/discussions.component';
import { RepliesComponent } from './components/discussion_forum/replies/replies.component';
import { AllAssignmentsComponent } from './components/instructor_components/all-assignments/all-assignments.component';
import { AssignmentReportComponent } from './components/instructor_components/assignment-report/assignment-report.component';
import { AssignmentComponent } from './components/instructor_components/assignment/assignment.component';
import { InstructorCoursesComponent } from './components/instructor_components/instructor-courses/instructor-courses.component';
import { InstructorLessonsComponent } from './components/instructor_components/instructor-lessons/instructor-lessons.component';
import { ViewPostedassignmentComponent } from './components/instructor_components/view-postedassignment/view-postedassignment.component';
import { ForgotpasswordComponent } from './components/login_and_signup/forgotpassword/forgotpassword.component';
import { LoginComponent } from './components/login_and_signup/login/login.component';
import { SignupComponent } from './components/login_and_signup/signup/signup.component';
import { LessondescriptionComponent } from './components/student_components/lessondescription/lessondescription.component';
import { StudentCoursesComponent } from './components/student_components/student-courses/student-courses.component';
import { StudentLessonsComponent } from './components/student_components/student-lessons/student-lessons.component';
import { TakeAssignmentComponent } from './components/student_components/take-assignment/take-assignment.component';
import { ViewAssignmentComponent } from './components/student_components/view-assignment/view-assignment.component';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  { path: '', redirectTo: 'welcome', pathMatch: 'full' },
  { path: 'welcome', component: HomepageComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'forgotpass', component: ForgotpasswordComponent },
  { path: 'about', component: AboutComponent, canActivate: [AuthGuard]},
  { path: 'help', component: HelpnsupportComponent, canActivate: [AuthGuard] },
  { path: 'discussions', component: DiscussionsComponent, canActivate: [AuthGuard] },
  { path: 'replies', component: RepliesComponent, canActivate: [AuthGuard] },
  { path: 'instructorCourses', component: InstructorCoursesComponent, canActivate: [AuthGuard] },
  { path: 'studentCourses', component: StudentCoursesComponent, canActivate: [AuthGuard] },
  { path: 'instructorLessons/:courseId', component: InstructorLessonsComponent, canActivate: [AuthGuard] },
  { path: 'instructorHome', component: InstructorDashboardComponent, canActivate: [AuthGuard] },
  { path: 'studentHome', component: StudentDashboardComponent, canActivate: [AuthGuard] },
  { path: 'SummaryPage/:id', component: SummaryComponent, canActivate: [AuthGuard] },
  { path: 'Payment/:id', component: PaymentComponent, canActivate: [AuthGuard] },
  { path: 'PaymentProcessing', component: PaymentProcessingComponent, canActivate: [AuthGuard] },
  { path: 'PaymentSuccessfull', component: PaymentSuccessfulComponent, canActivate: [AuthGuard] },
  { path: 'lessons', component: StudentLessonsComponent, canActivate: [AuthGuard] },
  { path: 'lessondescription/:lessonId', component: LessondescriptionComponent, canActivate: [AuthGuard] },
  { path: 'viewAssignments', component: ViewAssignmentComponent, canActivate: [AuthGuard] },
  { path: 'assignments', component: AssignmentComponent, canActivate: [AuthGuard] },
  { path: 'takeAssignment/:assignmentId', component: TakeAssignmentComponent, canActivate: [AuthGuard] },
  { path: 'allAssignments', component: AllAssignmentsComponent, canActivate: [AuthGuard] },
  { path: 'viewPostedassignment/:id', component: ViewPostedassignmentComponent, canActivate: [AuthGuard] },
  { path: 'assignmentReport/:id', component: AssignmentReportComponent, canActivate: [AuthGuard] },
  { path: 'paymentReport', component: PaymentReportComponent, canActivate: [AuthGuard] },
  { path: 'paymentDetails/:courseId/:paymentId', component: PaymentDetailComponent, canActivate: [AuthGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
