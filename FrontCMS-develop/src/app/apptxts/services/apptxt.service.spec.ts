import { TestBed } from '@angular/core/testing';

import { ApptxtService } from './apptxt.service';

describe('ApptxtService', () => {
  let service: ApptxtService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApptxtService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
