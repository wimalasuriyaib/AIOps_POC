package com.aiopshackathon.carreservation.carservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aiopshackathon.carreservation.carservice.dto.CarRequest;
import com.aiopshackathon.carreservation.carservice.dto.CarResponse;
import com.aiopshackathon.carreservation.carservice.service.CarService;
import com.aiopshackathon.carreservation.carservice.service.CarServiceException;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin
@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    private static final Logger log = LoggerFactory.getLogger(CarController.class);

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String createCar(@RequestBody CarRequest carRequest) {
        log.info("Adding a new car: {}", carRequest);

        try {
            carService.createCar(carRequest);
            log.info("Successfully Added a New Car.");
            return "Successfully Added a New Car";
        } catch (Exception e) {
            log.error("Failed to add a new car. Error: {}", e.getMessage(), e);
            throw new CarServiceException("Failed to add a new car.", e);
        }

    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<CarResponse> getAllCars() {
        log.info("Fetching all cars...");
        return carService.getAllCars();
    }

    @GetMapping("/{locationUuid}")
    @ResponseStatus(HttpStatus.OK)
    public List<CarResponse> getCarsByLocation(@PathVariable String locationUuid) {
        log.info("Fetching cars by location: {}", locationUuid);
        return carService.getCarsByLocation(locationUuid);
    }

    @GetMapping("/car/{carId}")
    @ResponseStatus(HttpStatus.OK)
    public CarResponse getCarById(@PathVariable int carId) {
        log.info("Fetching car by ID: {}", carId);
        return carService.getCarById(carId);
    }
}
