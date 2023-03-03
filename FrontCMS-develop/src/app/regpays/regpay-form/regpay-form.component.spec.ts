import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegpayFormComponent } from './regpay-form.component';

describe('RegpayFormComponent', () => {
  let component: RegpayFormComponent;
  let fixture: ComponentFixture<RegpayFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegpayFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegpayFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
