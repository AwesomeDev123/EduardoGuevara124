import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppmodListComponent } from './appmod-list.component';

describe('AppmodListComponent', () => {
  let component: AppmodListComponent;
  let fixture: ComponentFixture<AppmodListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppmodListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppmodListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
