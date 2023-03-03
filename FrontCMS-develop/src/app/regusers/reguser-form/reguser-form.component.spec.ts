import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReguserFormComponent } from './reguser-form.component';

describe('ReguserFormComponent', () => {
  let component: ReguserFormComponent;
  let fixture: ComponentFixture<ReguserFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReguserFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReguserFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
