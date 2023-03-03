import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegpayListComponent } from './regpay-list.component';

describe('RegpayListComponent', () => {
  let component: RegpayListComponent;
  let fixture: ComponentFixture<RegpayListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegpayListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegpayListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
