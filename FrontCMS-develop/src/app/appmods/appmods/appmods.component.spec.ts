import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppmodsComponent } from './appmods.component';

describe('AppmodsComponent', () => {
  let component: AppmodsComponent;
  let fixture: ComponentFixture<AppmodsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppmodsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppmodsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
