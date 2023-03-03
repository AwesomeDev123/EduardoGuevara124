import { TestBed } from '@angular/core/testing';

import { AppoptService } from './appopt.service';

describe('AppoptService', () => {
  let service: AppoptService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AppoptService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
