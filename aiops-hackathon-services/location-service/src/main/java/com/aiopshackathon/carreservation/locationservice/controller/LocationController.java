package com.aiopshackathon.carreservation.locationservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aiopshackathon.carreservation.locationservice.dto.LocationRequest;
import com.aiopshackathon.carreservation.locationservice.dto.LocationResponse;
import com.aiopshackathon.carreservation.locationservice.service.LocationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationservice;
    private static final Logger log = LoggerFactory.getLogger(LocationController.class);

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createLocation(@RequestBody LocationRequest locationRequest) {
        log.info("Creating a new location...");
        boolean locationExists = locationservice.locationExists(locationRequest);

        if (locationExists) {
            log.warn("Location already exists.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Location already exists.");
        } else {
            log.info("Location does not exist. Creating it...");
            locationservice.createLocation(locationRequest);
            log.info("Location created successfully.");
            return ResponseEntity.status(HttpStatus.CREATED).body("Location created successfully.");
        }
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<LocationResponse> getAllLocations() {
        log.info("Fetching all locations...");
        return locationservice.getAllLocations();
    }

    @GetMapping("/{locationUuid}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LocationResponse> getLocationDetails(@PathVariable String locationUuid) {
        log.info("Fetching location details for locationUuid: {}", locationUuid);

        LocationResponse locationResponse = locationservice.getLocationDetails(locationUuid);

        if (locationResponse != null) {
            log.info("Location details found.");
            return ResponseEntity.status(HttpStatus.OK).body(locationResponse);
        } else {
            log.warn("Location not found for locationUuid: {}", locationUuid);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
