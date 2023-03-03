import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApptxtFormComponent } from './apptxt-form.component';

describe('ApptxtFormComponent', () => {
  let component: ApptxtFormComponent;
  let fixture: ComponentFixture<ApptxtFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApptxtFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ApptxtFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
