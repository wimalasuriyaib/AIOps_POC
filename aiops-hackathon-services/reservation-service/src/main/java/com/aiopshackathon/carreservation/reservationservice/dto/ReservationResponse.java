package com.aiopshackathon.carreservation.reservationservice.dto;

import java.util.Date;

import com.aiopshackathon.carreservation.reservationservice.enums.ReservationStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponse {
    private long id;
    private String reservationNumber;
    private Date startDate;
    private Date endDate;
    private ReservationStatus reservationStatus;
    private String reservationCarCode;
    private long carQuantity;
    private double totalCost;
}
