import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppmodFormComponent } from './appmod-form.component';

describe('AppmodFormComponent', () => {
  let component: AppmodFormComponent;
  let fixture: ComponentFixture<AppmodFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppmodFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppmodFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
