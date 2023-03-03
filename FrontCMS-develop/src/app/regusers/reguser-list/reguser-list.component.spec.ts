import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReguserListComponent } from './reguser-list.component';

describe('ReguserListComponent', () => {
  let component: ReguserListComponent;
  let fixture: ComponentFixture<ReguserListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReguserListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReguserListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
