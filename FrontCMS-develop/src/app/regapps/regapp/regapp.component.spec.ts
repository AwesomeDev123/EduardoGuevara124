import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegappComponent } from './regapp.component';

describe('RegappComponent', () => {
  let component: RegappComponent;
  let fixture: ComponentFixture<RegappComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegappComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegappComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
