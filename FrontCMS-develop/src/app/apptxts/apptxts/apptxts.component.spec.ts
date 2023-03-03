import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppTxtsComponent } from './apptxts.component';

describe('ApptxtsComponent', () => {
  let component: AppTxtsComponent;
  let fixture: ComponentFixture<AppTxtsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppTxtsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppTxtsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
