import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppimgListComponent } from './appimg-list.component';

describe('AppimgListComponent', () => {
  let component: AppimgListComponent;
  let fixture: ComponentFixture<AppimgListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppimgListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppimgListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
