package com.aiopshackathon.carreservation.reservationservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aiopshackathon.carreservation.reservationservice.dto.ReservationRequest;
import com.aiopshackathon.carreservation.reservationservice.dto.ReservationResponse;
import com.aiopshackathon.carreservation.reservationservice.service.ReservationException;
import com.aiopshackathon.carreservation.reservationservice.service.ReservationService;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private static final Logger log = LoggerFactory.getLogger(ReservationController.class);

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String makeCarReservation(@RequestBody ReservationRequest reservationRequest) {
        log.info("Received a new reservation request: {}", reservationRequest);

        try {
            reservationService.makeCarReservation(reservationRequest);
            log.info("Reservation placed successfully.");
            return "Reservation Placed Successfully";
        } catch (Exception e) {
            log.error("Failed to place reservation. Error: {}", e.getMessage(), e);
            throw new ReservationException("Failed to create reservation.", e);
        }
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<ReservationResponse> getAllReservations() {
        log.info("Fetching all reservations...");
        return reservationService.getAllReservations();
    }

    @PatchMapping("/{reservationId}/cancel")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> cancelReservation(@PathVariable Long reservationId) {
        log.info("Cancelling reservation with ID: {}", reservationId);

        try {
            reservationService.cancelReservation(reservationId);

            log.info("Reservation with ID {} cancelled successfully.", reservationId);
            return ResponseEntity.status(HttpStatus.OK).body("Reservation Cancelled Successfully");
        } catch (Exception e) {
            log.error("Failed to cancel reservation. Error: {}", e.getMessage(), e);
            throw new ReservationException("Failed to cancel reservation.", e);
        }
    }


}
