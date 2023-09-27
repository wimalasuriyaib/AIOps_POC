import { TestBed } from '@angular/core/testing';

import { CarReservationsService } from './car-reservations.service';

describe('CarReservationsService', () => {
  let service: CarReservationsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CarReservationsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
