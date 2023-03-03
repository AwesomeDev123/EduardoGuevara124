import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApptpltsComponent } from './apptplate.component';

describe('ApptpltsComponent', () => {
  let component: ApptpltsComponent;
  let fixture: ComponentFixture<ApptpltsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApptpltsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ApptpltsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
