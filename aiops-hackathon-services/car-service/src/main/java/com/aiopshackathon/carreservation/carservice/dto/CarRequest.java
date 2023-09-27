package com.aiopshackathon.carreservation.carservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarRequest {
    private String carCode;
    private String make;
    private String model;
    private int year;
    private String licensePlate;
    private boolean availability;
    private String imageURL;
    private String locationUuid;
    private double perHourRate;
    private double perDayRate;
    private double leasingRate;
    private String carDescription;
    private Long mileage;
    private String transmission;
    private int seats;
    private int luggage;
    private String fuel;
}
