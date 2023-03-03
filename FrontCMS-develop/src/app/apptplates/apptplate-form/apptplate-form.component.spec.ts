import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApptpltsFormComponent } from './apptplate-form.component';

describe('ApptpltsFormComponent', () => {
  let component: ApptpltsFormComponent;
  let fixture: ComponentFixture<ApptpltsFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApptpltsFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ApptpltsFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
