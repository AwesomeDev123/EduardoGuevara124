import { TestBed } from '@angular/core/testing';

import { RegUserService } from './reguser-service';

describe('ServicesService', () => {
  let service: RegUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegUserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
