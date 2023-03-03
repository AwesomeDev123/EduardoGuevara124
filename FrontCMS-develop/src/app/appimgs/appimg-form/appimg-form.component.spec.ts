import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppimgFormComponent } from './appimg-form.component';

describe('AppimgFormComponent', () => {
  let component: AppimgFormComponent;
  let fixture: ComponentFixture<AppimgFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppimgFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppimgFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
