import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppTpltListComponent } from './apptplate-list.component';

describe('ApptpltsListComponent', () => {
  let component: AppTpltListComponent;
  let fixture: ComponentFixture<AppTpltListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppTpltListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppTpltListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
