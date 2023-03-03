import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegappListComponent } from './regapp-list.component';

describe('RegappListComponent', () => {
  let component: RegappListComponent;
  let fixture: ComponentFixture<RegappListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegappListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegappListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
