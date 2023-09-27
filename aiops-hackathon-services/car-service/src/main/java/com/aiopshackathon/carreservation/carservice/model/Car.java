package com.aiopshackathon.carreservation.carservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @NotNull
    @Column(name = "car_code")
    private String carCode;

    @NotNull
    @Column(name = "make")
    private String make;

    @NotNull
    @Column(name = "model")
    private String model;

    @NotNull
    @Column(name = "year")
    private int year;

    @NotNull
    @Column(name = "license_plate", unique = true)
    private String licensePlate;

    @NotNull
    @Column(name = "availability")
    private boolean availability;

    @Column(name = "image_url")
    private String imageURL;

    @Column(name = "car_description")
    private String carDescription;

    @Column(name = "mileage")
    private Long mileage;

    @Column(name = "transmission")
    private String transmission;

    @Column(name = "seats")
    private int seats;

    @Column(name = "luggage")
    private int luggage;

    @Column(name = "fuel")
    private String fuel;

    @NotNull
    @Column(name = "location_uuid", nullable = false)
    private String locationUuid;

    @NotNull(message = "Per Hour Rate cannot be null")
    @DecimalMin(value = "0.0", message = "Per Hour Rate must be greater than or equal to 0")
    @Column(name = "per_hour_rate", nullable = false)
    private double perHourRate;

    @NotNull(message = "Per Day Rate cannot be null")
    @DecimalMin(value = "0.0", message = "Per Day Rate must be greater than or equal to 0")
    @Column(name = "per_day_rate", nullable = false)
    private double perDayRate;

    @NotNull(message = "Leasing Rate cannot be null")
    @DecimalMin(value = "0.0", message = "Leasing Rate must be greater than or equal to 0")
    @Column(name = "leasing_rate", nullable = false)
    private double leasingRate;
}
