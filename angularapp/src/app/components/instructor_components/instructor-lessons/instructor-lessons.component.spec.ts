import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorLessonsComponent } from './instructor-lessons.component';

describe('InstructorLessonsComponent', () => {
  let component: InstructorLessonsComponent;
  let fixture: ComponentFixture<InstructorLessonsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorLessonsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InstructorLessonsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
