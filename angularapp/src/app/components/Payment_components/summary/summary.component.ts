import { Location } from '@angular/common';
import { Component, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Course } from 'src/app/models/course';
import { CourseServiceImpl } from 'src/app/services/course.service';

@Component({
  selector: 'app-summary',
  templateUrl: './summary.component.html',
  styleUrls: ['./summary.component.css']
})

export class SummaryComponent {
  courseId: number = 0;
  price: number = 200;
  course: Course = {
    courseId: 0,
    courseName: '',
    courseDescription: '',
    instructorId: 0
  };

  constructor(private courseService: CourseServiceImpl, private router: Router, private route: ActivatedRoute, private location: Location) { }

  ngOnInit(): void {
    this.courseId = this.route.snapshot.params['id'];
    this.courseService.getCourseByCourseId(this.courseId).subscribe((response: Course) => {
      this.course = response
    })
  }

  //redirect to payment page
  GoToPaymentPage(id: number) {
    this.router.navigate(['Payment', id]);
  }

  //redirect to courses page on back button click
  onback() {
    this.router.navigate(['/studentCourses']);
  }

}
