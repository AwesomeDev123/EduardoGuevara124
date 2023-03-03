import { TestBed } from '@angular/core/testing';

import { AppimgService } from './appimg.service';

describe('AppimgService', () => {
  let service: AppimgService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AppimgService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
