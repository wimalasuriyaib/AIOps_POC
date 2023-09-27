package com.aiopshackathon.carreservation.locationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aiopshackathon.carreservation.locationservice.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, String> {

    @Query("SELECT COUNT(l) > 0 FROM Location l WHERE UPPER(l.locationName) = UPPER(:locationName) OR UPPER(l.locationAddress) = UPPER(:locationAddress)")
    boolean existsByLocationNameAndLocationAddress(
        @Param("locationName") String locationName,
        @Param("locationAddress") String locationAddress
    );

    Location findByLocationUuid(String locationUuid);
}
