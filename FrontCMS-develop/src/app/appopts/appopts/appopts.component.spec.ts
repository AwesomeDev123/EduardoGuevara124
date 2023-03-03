import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppoptsComponent } from './appopts.component';

describe('AppoptsComponent', () => {
  let component: AppoptsComponent;
  let fixture: ComponentFixture<AppoptsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppoptsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppoptsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
