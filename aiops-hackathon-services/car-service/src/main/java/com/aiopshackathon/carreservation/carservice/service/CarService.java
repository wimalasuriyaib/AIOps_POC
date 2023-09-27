package com.aiopshackathon.carreservation.carservice.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.aiopshackathon.carreservation.carservice.dto.CarRequest;
import com.aiopshackathon.carreservation.carservice.dto.CarResponse;
import com.aiopshackathon.carreservation.carservice.dto.LocationResponse;
import com.aiopshackathon.carreservation.carservice.model.Car;
import com.aiopshackathon.carreservation.carservice.repository.CarRepository;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private static final Logger log = LoggerFactory.getLogger(CarService.class);
    private final WebClient webClient;

    public void createCar(CarRequest carRequest) {
        Car car = new Car();
        car.setCarCode(UUID.randomUUID().toString());
                car.setMake(carRequest.getMake());
                car.setModel(carRequest.getModel());
                car.setYear(carRequest.getYear());
                car.setLicensePlate(carRequest.getLicensePlate());
                car.setAvailability(carRequest.isAvailability());
                car.setImageURL(carRequest.getImageURL());
                car.setLocationUuid(carRequest.getLocationUuid());
                car.setPerHourRate(carRequest.getPerHourRate());
                car.setPerDayRate(carRequest.getPerDayRate());
                car.setLeasingRate(carRequest.getLeasingRate());
                car.setCarDescription(carRequest.getCarDescription());
                car.setMileage(carRequest.getMileage());
                car.setTransmission(carRequest.getTransmission());
                car.setSeats(carRequest.getSeats());
                car.setLuggage(carRequest.getLuggage());
                car.setFuel(carRequest.getFuel());

        carRepository.save(car);

        log.info("Car {} is saved", car.getId());
    }

    public List<CarResponse> getAllCars() {
        try {

            List<Car> cars = carRepository.findAll();

            return cars.stream()
                    .map(this::mapToCarResponse)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Failed to fetch all cars. Error: {}", e.getMessage(), e);
            throw new CarServiceException("Failed to fetch all cars.", e);
        }

    }

    public List<CarResponse> getCarsByLocation(String locationUuid) {
        List<Car> cars = carRepository.findByLocationUuid(locationUuid);

        return cars.stream()
                .map(this::mapToCarResponse)
                .collect(Collectors.toList());
    }

    private CarResponse mapToCarResponse(Car car) {
        return CarResponse.builder()
                .id(car.getId())
                .carCode(car.getCarCode())
                .make(car.getMake())
                .model(car.getModel())
                .year(car.getYear())
                .licensePlate(car.getLicensePlate())
                .imageURL(car.getImageURL())
                .availability(car.isAvailability())
                .imageURL(car.getImageURL())
                .locationUuid(car.getLocationUuid())
                .perHourRate(car.getPerHourRate())
                .perDayRate(car.getPerDayRate())
                .leasingRate(car.getLeasingRate())
                .carDescription(car.getCarDescription())
                .mileage(car.getMileage())
                .transmission(car.getTransmission())
                .seats(car.getSeats())
                .luggage(car.getLuggage())
                .fuel(car.getFuel())
                .build();
    }

    public CarResponse getCarById(int carId) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new CarServiceException("Car not found with ID: " + carId));

        LocationResponse locationResponse = getLocationDetails(car.getLocationUuid());

        CarResponse carResponse = mapToACarResponse(car, locationResponse);

        return carResponse;
    }

    private LocationResponse getLocationDetails(String locationUuid) {
        return webClient.get()
                .uri("http://localhost:9003/api/locations/{locationUuid}", locationUuid)
                .retrieve()
                .bodyToMono(LocationResponse.class)
                .block();
    }

    private CarResponse mapToACarResponse(Car car, LocationResponse locationResponse) {

        return CarResponse.builder()
                .id(car.getId())
                .carCode(car.getCarCode())
                .make(car.getMake())
                .model(car.getModel())
                .year(car.getYear())
                .licensePlate(car.getLicensePlate())
                .imageURL(car.getImageURL())
                .availability(car.isAvailability())
                .imageURL(car.getImageURL())
                .locationUuid(car.getLocationUuid())
                .perHourRate(car.getPerHourRate())
                .perDayRate(car.getPerDayRate())
                .leasingRate(car.getLeasingRate())
                .locationName(locationResponse.getLocationName())
                .locationAddress(locationResponse.getLocationAddress())
                .carDescription(car.getCarDescription())
                .mileage(car.getMileage())
                .transmission(car.getTransmission())
                .seats(car.getSeats())
                .luggage(car.getLuggage())
                .fuel(car.getFuel())
                .build();
    }
}
