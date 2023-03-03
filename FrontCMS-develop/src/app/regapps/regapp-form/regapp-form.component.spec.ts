import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegappFormComponent } from './regapp-form.component';

describe('RegappFormComponent', () => {
  let component: RegappFormComponent;
  let fixture: ComponentFixture<RegappFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegappFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegappFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
