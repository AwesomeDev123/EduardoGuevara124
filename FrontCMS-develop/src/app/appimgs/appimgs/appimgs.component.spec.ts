import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppimgsComponent } from './appimgs.component';

describe('AppimgsComponent', () => {
  let component: AppimgsComponent;
  let fixture: ComponentFixture<AppimgsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppimgsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppimgsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
