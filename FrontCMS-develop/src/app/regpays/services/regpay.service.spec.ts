import { TestBed } from '@angular/core/testing';

import { RegpaysService } from './regpay.service';

describe('RegpaysService', () => {
  let service: RegpaysService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegpaysService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
