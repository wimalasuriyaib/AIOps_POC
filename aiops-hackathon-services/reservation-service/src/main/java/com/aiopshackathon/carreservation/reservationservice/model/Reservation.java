package com.aiopshackathon.carreservation.reservationservice.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.aiopshackathon.carreservation.reservationservice.enums.ReservationStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_reservations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @NotNull
    @Column(name = "reservation_number", nullable = false)
    private String reservationNumber;

    @NotNull
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @NotNull
    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @NotNull
    @Column(name = "reservation_status", nullable = false)
    private ReservationStatus reservationStatus;

    @NotNull
    @Column(name = "reservation_car_code", nullable = false)
    private String reservationCarCode;

    @NotNull
    @Column(name = "car_quantity", nullable = false)
    private long carQuantity;

    @NotNull
    @Column(name = "total_cost", nullable = false)
    private double totalCost;

}
