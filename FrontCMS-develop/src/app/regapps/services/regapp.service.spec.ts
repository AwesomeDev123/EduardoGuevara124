import { TestBed } from '@angular/core/testing';

import { RegappService } from './regapp.service';

describe('RegappService', () => {
  let service: RegappService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegappService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
