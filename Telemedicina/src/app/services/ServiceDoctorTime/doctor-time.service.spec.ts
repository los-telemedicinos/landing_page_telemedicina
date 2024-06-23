import { TestBed } from '@angular/core/testing';

import { DoctorTimeService } from './doctor-time.service';

describe('DoctorTimeService', () => {
  let service: DoctorTimeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DoctorTimeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
