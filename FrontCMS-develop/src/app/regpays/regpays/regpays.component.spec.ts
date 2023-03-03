import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegpaysComponent } from './regpays.component';

describe('RegpaysComponent', () => {
  let component: RegpaysComponent;
  let fixture: ComponentFixture<RegpaysComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegpaysComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegpaysComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
