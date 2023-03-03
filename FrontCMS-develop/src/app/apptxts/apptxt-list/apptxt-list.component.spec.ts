import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApptxtListComponent } from './apptxt-list.component';

describe('ApptxtListComponent', () => {
  let component: ApptxtListComponent;
  let fixture: ComponentFixture<ApptxtListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApptxtListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ApptxtListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
