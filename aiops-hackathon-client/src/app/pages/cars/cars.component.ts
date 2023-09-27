import { Component, Input, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { CarsService } from './services/cars.service';
import { Router } from '@angular/router';
import { BsModalRef } from 'ngx-bootstrap/modal';
import * as bootstrap from 'bootstrap';
import { CarReservationsService } from '../car-reservations/services/car-reservations.service';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.scss'],
})
export class CarsComponent implements OnInit, OnDestroy {
  @ViewChild('myModal') myModal!: BsModalRef;
  isCollapsed = true;
  cars: any[] = [];
  allLocations: any[] = [];
  selectedLocation: string = 'All';
  reservation: any = {};
  reservationData: any = {};
  @Input() selectedCar: any;
  @Input() perDayRate: any;
  @Input() perHourRate: any;
  @Input() leasingRate: any;
  @Input() reservationCarCode: any;

  constructor(
    private carsService: CarsService, 
    private router: Router,
    private carReservationsService: CarReservationsService,
    ) {
    this.getAllLocations();
    if (this.selectedLocation === 'All') {
      this.getAllCars();
    }
  }

  ngOnInit() {
    var body = document.getElementsByTagName('body')[0];
    body.classList.add('cars-page');

    this.getAllCars();
  }

  getAllLocations() {
    this.carsService.getAllLocations().subscribe((data) => {
      if (data) {
        this.allLocations = data;
      }
    });
  }

  getAllCars() {
    this.carsService.getAllCars().subscribe((data) => {
      if (data) {
        this.cars = data;
      }
    });
  }

  onLocationChange(e: any) {
    if (this.selectedLocation === 'All') {
      this.getAllCars();
    } else {
      this.cars = [];
      this.carsService.getCarsByLocation(e).subscribe((data) => {
        if (data) {
          this.cars = data;
        }
      });
    }
  }

  isActiveRoute(route: string): boolean {
    return this.router.isActive(route, true);
  }

  openModal(car: any) {
    this.selectedCar = {};
    const element = document.getElementById('myModal') as HTMLElement;
    var myModal = new bootstrap.Modal(element);
    myModal.show();

    this.perDayRate = car.perDayRate;
    this.perHourRate = car.perHourRate;
    this.leasingRate = car.leasingRate;
    this.reservationCarCode = car.carCode;
  }

  submitReservation() {
    this.reservationData = {};
    const startDate = new Date(this.reservation.startDate).getTime();
    const endDate = new Date(this.reservation.endDate).getTime();
    const durationInMilliseconds = endDate - startDate;
    
    console.log(durationInMilliseconds);
    let totalCost = 0;

    if (this.reservation.pricing_type === 'perDayRate') {
      const days = durationInMilliseconds / (24 * 60 * 60 * 1000);
      console.log(days)
      totalCost = days * this.perDayRate;
    } else if (this.reservation.pricing_type === 'perHourRate') {
      const hours = durationInMilliseconds / (60 * 60 * 1000);
      console.log(hours)
      totalCost = hours * this.perHourRate;
    } else if (this.reservation.pricing_type === 'leasingRate') {
      const months = durationInMilliseconds / (30 * 24 * 60 * 60 * 1000);
      console.log(months)
      totalCost = months * this.leasingRate;
    }

    this.reservationData = {
      startDate: this.reservation.startDate,
      endDate: this.reservation.endDate,
      reservationStatus: 0,
      reservationCarCode: this.reservationCarCode,
      carQuantity: this.reservation.carQuantity,
      totalCost: totalCost,
    };

    this.carReservationsService.makeCarReservation(this.reservationData)
    .subscribe(
      (response) => {
        this.closeModel();
      },
      (error) => {
        console.log(error)
        this.closeModel();
      },
    );
    console.log(this.reservationData)
  }

  closeModel() {
    const element = document.getElementById('myModal') as HTMLElement;
    var myModal = bootstrap.Modal.getOrCreateInstance(element);
    myModal.hide();
  }

  ngOnDestroy() {
    var body = document.getElementsByTagName('body')[0];
    body.classList.remove('cars-page');
  }
}
