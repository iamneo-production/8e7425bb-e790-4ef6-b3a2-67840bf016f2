import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LessondescriptionComponent } from './lessondescription.component';

describe('LessondescriptionComponent', () => {
  let component: LessondescriptionComponent;
  let fixture: ComponentFixture<LessondescriptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LessondescriptionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LessondescriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
