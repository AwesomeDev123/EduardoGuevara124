import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppagreesComponent } from './appagrees.component';

describe('AppagreesComponent', () => {
  let component: AppagreesComponent;
  let fixture: ComponentFixture<AppagreesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppagreesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppagreesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
