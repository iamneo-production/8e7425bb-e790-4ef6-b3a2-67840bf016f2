import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPostedassignmentComponent } from './view-postedassignment.component';

describe('ViewPostedassignmentComponent', () => {
  let component: ViewPostedassignmentComponent;
  let fixture: ComponentFixture<ViewPostedassignmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewPostedassignmentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewPostedassignmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
