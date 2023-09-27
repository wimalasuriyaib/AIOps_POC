import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CarReservations } from 'src/app/entity/CarReservations';

@Injectable({
  providedIn: 'root',
})
export class CarReservationsService {
  constructor(private http: HttpClient) { }

  // getall
  getAllCarReservations(): Observable<any> {
    return this.http.get<CarReservations[]>(
      `${environment.baseUrl}${environment.carReservationServiceUrl}`
    );
  }

  makeCarReservation(reservationData: any): Observable<any> {
    return this.http.post<any>('/api/reservations/', reservationData);
  }

  cancelReservation(data: any, reservationId: number): Observable<any> {
    return this.http.patch<any>(
      '/api/reservations/' + reservationId + '/cancel',
      data,
      {
        headers: { 'content-type': 'application/json' },
      }
    );
  }
}
