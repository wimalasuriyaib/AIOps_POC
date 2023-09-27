package com.aiopshackathon.carreservation.locationservice.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aiopshackathon.carreservation.locationservice.dto.LocationRequest;
import com.aiopshackathon.carreservation.locationservice.dto.LocationResponse;
import com.aiopshackathon.carreservation.locationservice.model.Location;
import com.aiopshackathon.carreservation.locationservice.repository.LocationRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class LocationService {

    private final LocationRepository locationRepository;

    public boolean locationExists(LocationRequest locationRequest) {
        return locationRepository.existsByLocationNameAndLocationAddress(
                locationRequest.getLocationName(),
                locationRequest.getLocationAddress());
    }

    public void createLocation(LocationRequest locationRequest) {
        Location location = new Location();
        location.setLocationName(locationRequest.getLocationName());
        location.setLocationAddress(locationRequest.getLocationAddress());
        location.setLocationUuid(UUID.randomUUID().toString());

        locationRepository.save(location);
        log.info("Location {} is saved", location.getId());
    }

    public List<LocationResponse> getAllLocations() {
        List<Location> locations = locationRepository.findAll();

        return locations.stream()
                .map(this::mapToCarResponse)
                .collect(Collectors.toList());
    }

    private LocationResponse mapToCarResponse(Location location) {
        return LocationResponse.builder()
                .id(location.getId())
                .locationName(location.getLocationName())
                .locationAddress(location.getLocationAddress())
                .locationUuid(location.getLocationUuid())
                .build();
    }

    public LocationResponse getLocationDetails(String locationUuid) {

        Location location = locationRepository.findByLocationUuid(locationUuid);

        if (location != null) {
            LocationResponse response = mapToCarResponse(location);
            return response;
        } else {
            return null;
        }
    }

}
