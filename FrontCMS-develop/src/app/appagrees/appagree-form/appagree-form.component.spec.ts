import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppagreeFormComponent } from './appagree-form.component';

describe('AppagreeFormComponent', () => {
  let component: AppagreeFormComponent;
  let fixture: ComponentFixture<AppagreeFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppagreeFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppagreeFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
