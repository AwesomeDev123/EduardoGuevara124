import { TestBed } from '@angular/core/testing';

import { ApptpltService } from './apptplate.service';

describe('ApptpltService', () => {
  let service: ApptpltService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApptpltService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
