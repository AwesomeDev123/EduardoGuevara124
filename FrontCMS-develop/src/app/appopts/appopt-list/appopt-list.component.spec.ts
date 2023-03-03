import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppoptListComponent } from './appopt-list.component';

describe('AppoptListComponent', () => {
  let component: AppoptListComponent;
  let fixture: ComponentFixture<AppoptListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppoptListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppoptListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
