import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CarsService } from '../cars/services/cars.service';

@Component({
  selector: 'app-car-single',
  templateUrl: './car-single.component.html',
  styleUrls: ['./car-single.component.scss']
})
export class CarSingleComponent implements OnInit {
  isCollapsed = true;
  car: any;

  constructor(
    private route: ActivatedRoute,
    private carsService: CarsService) {
    
    const carId = this.route.snapshot.paramMap.get('id');
      if (carId) {
        
      this.carsService.getCarByID(carId).subscribe(
        (response) => {
          if (response) {
            this.car = response;
          }
        },
        (error: any) => {
          console.log(error);
        },
      );
    }

  }

  ngOnInit(): void {
  }

}
