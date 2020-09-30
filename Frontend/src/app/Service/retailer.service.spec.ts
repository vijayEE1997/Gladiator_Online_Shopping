import { TestBed } from '@angular/core/testing';

import { RetailerService } from './retailer.service';

describe('RetailerService', () => {
  let service: RetailerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RetailerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
