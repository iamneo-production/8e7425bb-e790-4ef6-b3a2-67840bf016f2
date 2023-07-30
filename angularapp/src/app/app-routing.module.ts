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

const routes: Routes = [
  { path: '', redirectTo: 'welcome', pathMatch: 'full' },
  { path: 'welcome', component: HomepageComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'forgotpass', component: ForgotpasswordComponent },
  { path: 'about', component: AboutComponent },
  { path: 'help', component: HelpnsupportComponent },
  { path: 'discussions', component: DiscussionsComponent },
  { path: 'replies', component: RepliesComponent },
  { path: 'instructorCourses', component: InstructorCoursesComponent },
  { path: 'studentCourses', component: StudentCoursesComponent },
  { path: 'instructorLessons/:courseId', component: InstructorLessonsComponent },
  { path: 'instructorHome', component: InstructorDashboardComponent },
  { path: 'studentHome', component: StudentDashboardComponent },
  { path: 'SummaryPage/:id', component: SummaryComponent },
  { path: 'Payment/:id', component: PaymentComponent },
  { path: 'PaymentProcessing', component: PaymentProcessingComponent },
  { path: 'PaymentSuccessfull', component: PaymentSuccessfulComponent },
  { path: 'lessons', component: StudentLessonsComponent },
  { path: 'lessondescription/:lessonId', component: LessondescriptionComponent },
  { path: 'viewAssignments', component: ViewAssignmentComponent },
  { path: 'assignments', component: AssignmentComponent },
  { path: 'takeAssignment/:assignmentId', component: TakeAssignmentComponent },
  { path: 'allAssignments', component: AllAssignmentsComponent },
  { path: 'viewPostedassignment/:id', component: ViewPostedassignmentComponent },
  { path: 'assignmentReport/:id', component: AssignmentReportComponent },
  { path: 'paymentReport', component: PaymentReportComponent },
  { path: 'paymentDetails/:courseId/:paymentId', component: PaymentDetailComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
