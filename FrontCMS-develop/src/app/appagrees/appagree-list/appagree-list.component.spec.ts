import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppagreeListComponent } from './appagree-list.component';

describe('AppagreeListComponent', () => {
  let component: AppagreeListComponent;
  let fixture: ComponentFixture<AppagreeListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppagreeListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppagreeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
