import { TestBed } from '@angular/core/testing';

import { AppagreeService } from './appagree.service';

describe('AppagreeService', () => {
  let service: AppagreeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AppagreeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
