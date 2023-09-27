package com.aiopshackathon.carreservation.reservationservice.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aiopshackathon.carreservation.reservationservice.dto.ReservationRequest;
import com.aiopshackathon.carreservation.reservationservice.dto.ReservationResponse;
import com.aiopshackathon.carreservation.reservationservice.enums.ReservationStatus;
import com.aiopshackathon.carreservation.reservationservice.model.Reservation;
import com.aiopshackathon.carreservation.reservationservice.repository.ReservationRepository;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private static final Logger log = LoggerFactory.getLogger(ReservationService.class);

    public void makeCarReservation(ReservationRequest reservationRequest) {
        Reservation reservation = new Reservation();
        reservation.setReservationNumber(UUID.randomUUID().toString());
        reservation.setEndDate(reservationRequest.getStartDate());
        reservation.setEndDate(reservationRequest.getEndDate());
        reservation.setReservationStatus(reservationRequest.getReservationStatus());
        reservation.setReservationCarCode(reservationRequest.getReservationCarCode());
        reservation.setCarQuantity(reservationRequest.getCarQuantity());
        reservation.setTotalCost(reservationRequest.getTotalCost());

        reservationRepository.save(reservation);

        log.info("Reservation {} is saved", reservation.getId());
    }

    public List<ReservationResponse> getAllReservations() {
        try {
            List<Reservation> reservations = reservationRepository.findAll();

            return reservations.stream()
                    .map(this::mapToReservationResponse)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Failed to fetch all reservations. Error: {}", e.getMessage(), e);
            throw new ReservationException("Failed to fetch all reservations.", e);
        }
    }

    private ReservationResponse mapToReservationResponse(Reservation reservation) {
        return ReservationResponse.builder()
                .id(reservation.getId())
                .reservationNumber(reservation.getReservationNumber())
                .startDate(reservation.getStartDate())
                .endDate(reservation.getEndDate())
                .reservationStatus(reservation.getReservationStatus())
                .reservationCarCode(reservation.getReservationCarCode())
                .carQuantity(reservation.getCarQuantity())
                .totalCost(reservation.getTotalCost())
                .build();
    }

    public void cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ReservationException("Reservation not found"));

        reservation.setReservationStatus(ReservationStatus.CANCELED);

        reservationRepository.save(reservation);
    }
}
