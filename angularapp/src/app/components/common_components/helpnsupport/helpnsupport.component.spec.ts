import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HelpnsupportComponent } from './helpnsupport.component';

describe('HelpnsupportComponent', () => {
  let component: HelpnsupportComponent;
  let fixture: ComponentFixture<HelpnsupportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HelpnsupportComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HelpnsupportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
