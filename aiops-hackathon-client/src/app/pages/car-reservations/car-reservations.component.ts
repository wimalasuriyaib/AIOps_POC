import { Component, OnDestroy, OnInit } from '@angular/core';
import { CarReservationsService } from './services/car-reservations.service';
import * as moment from 'moment';

@Component({
  selector: 'app-car-reservations',
  templateUrl: './car-reservations.component.html',
  styleUrls: ['./car-reservations.component.scss'],
})
export class CarReservationsComponent implements OnInit, OnDestroy {
  isCollapsed = true;
  data: any
  carReservations: any[] = [];
  selectedReservationId: number = 0;

  momentParser = moment;
  constructor(
    private carReservationsService: CarReservationsService
    ) { }

  ngOnInit() {
    var body = document.getElementsByTagName('body')[0];
    body.classList.add('car-reservation-page');

    this.getAllCarReservations();

  }

  getAllCarReservations() {
    this.carReservationsService.getAllCarReservations().subscribe((data) => {
      if (data) {
        this.carReservations = data;
      }
    });
  }

  selectReservationForCancellation(reservationId: number) {
    this.selectedReservationId = reservationId;
  }
  
  cancelReservation(reservationId: number) {
    this.carReservationsService.cancelReservation(this.data, reservationId).subscribe(
      (response) => {
      },
      (error) => {
        console.log(error);
      },
    );
  }
  ngOnDestroy() {
    var body = document.getElementsByTagName('body')[0];
    body.classList.remove('car-reservation-page');
  }
}
