import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { BrowserModule } from "@angular/platform-browser";
import { Routes, RouterModule } from "@angular/router";

import { HomeComponent } from "./pages/home/home.component";
import { CarsComponent } from "./pages/cars/cars.component";
import { PricingComponent } from "./pages/pricing/pricing.component";
import { CarReservationsComponent } from "./pages/car-reservations/car-reservations.component";
import { CarSingleComponent } from "./pages/car-single/car-single.component";

const routes: Routes = [
  { path: "", redirectTo: "home", pathMatch: "full" },
  { path: "home", component: HomeComponent },
  { path: "cars", component: CarsComponent },
  { path: "pricing", component: PricingComponent },
  { path: "car-reservations", component: CarReservationsComponent },
  { path: "car/car-details/:id", component: CarSingleComponent }
];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes, {
      useHash: true
    })
  ],
  exports: []
})
export class AppRoutingModule {}
