import { Component, OnDestroy, OnInit } from '@angular/core';
import { PricingService } from './services/pricing.service';

@Component({
  selector: 'app-pricing',
  templateUrl: './pricing.component.html',
  styleUrls: ['./pricing.component.scss']
})

export class PricingComponent implements OnInit, OnDestroy {
  isCollapsed = true;
  cars: any[] = [];
  constructor(
    private pricingService: PricingService,
    ) { }

  ngOnInit() {
    var body = document.getElementsByTagName("body")[0];
    body.classList.add("cars-page");

    this.getAllCars();
  }

  getAllCars() {
    this.pricingService.getAllCars().subscribe((data) => {
      if (data) {
        this.cars = data;
      }
    });
  }

  ngOnDestroy() {
    var body = document.getElementsByTagName("body")[0];
    body.classList.remove("cars-page");
  }
}