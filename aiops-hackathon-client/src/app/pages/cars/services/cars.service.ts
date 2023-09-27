import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { CarReservations } from 'src/app/entity/CarReservations';

@Injectable({
  providedIn: 'root'
})
export class CarsService {

  constructor(private http: HttpClient) { }

    // getall
    getAllCars(): Observable<any> {
      return this.http.get<CarReservations[]>(
        `${environment.baseUrl}${environment.carsServiceUrl}`
      );
    }

    getCarByID(carId: any): Observable<any> {
      return this.http.get<any>(`${environment.baseUrl}${environment.carsServiceUrl}car/` + carId);
    }
  
    getCarsByLocation(locationUuid: any): Observable<any> {
      return this.http.get<any>(`${environment.baseUrl}${environment.carsServiceUrl}` + locationUuid);
    }

    //getAllLocations
    getAllLocations(): Observable<any> {
      return this.http.get<CarReservations[]>(
        `${environment.baseUrl}${environment.locationsUrl}`
      );
    }
  
}
