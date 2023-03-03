import { TestBed } from '@angular/core/testing';

import { AppmodService } from './appmod.service';

describe('AppmodService', () => {
  let service: AppmodService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AppmodService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
