package com.aiopshackathon.carreservation.carservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aiopshackathon.carreservation.carservice.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {

    List<Car> findByLocationUuid(String locationUuid);

    Optional<Car> findById(int carId);

}
